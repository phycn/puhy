package cn.puhy.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.puhy.mybatis.mapper.TSerialMapper;
import cn.puhy.mybatis.model.TSerial;

public class SerialUtil {

	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlsession;
	private static TSerialMapper mapper;

	private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private static LinkedBlockingQueue<Long> q = new LinkedBlockingQueue<>();

	static {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			sqlsession = sqlSessionFactory.openSession();
			mapper = sqlsession.getMapper(TSerialMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static AtomicLong i = new AtomicLong();
	private static int limit;

	public long getSerial() throws InterruptedException {

		if (q.isEmpty()) {
			setLimit();
		}
		return q.take();
	}

	private synchronized void setLimit() {

		if (!q.isEmpty()) {
			return;
		}
		TSerial tSerial = mapper.query(1);
		long a = tSerial.getLimitNum();
		limit = tSerial.getCacheNum() + tSerial.getLimitNum();
		tSerial.setLimitNum(limit);
		mapper.update(tSerial);
		sqlsession.commit();
//		long start = System.currentTimeMillis();
		for (; a < limit; a++) {
			q.add(a);
		}
//		System.out.println(System.currentTimeMillis() - start);
	}

	public static void main(String[] args) throws InterruptedException {

		SerialUtil s = new SerialUtil();

		for (int i = 0; i < 400; i++) {
			Thread t1 = new Thread() {
				public void run() {

					try {
						for (int i = 0; i < 250; i++) {
//							s.getSerial();
							System.out.println(currentThread().getName() + " " + s.getSerial());
						}
						// System.out.println(currentThread().getName() + " " + s.getSerial());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			};
			t1.start();
		}
	}
}
