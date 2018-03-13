package cn.puhy.datastructure.hash;

import java.math.BigInteger;

public class MyHashTable {
    private Info[] arr;

    public MyHashTable() {
        arr = new Info[100];
    }

    public MyHashTable(int maxSize) {
        arr = new Info[maxSize];
    }

    /**
     * 普通插入，没有考虑冲突
     *
     * @param info
     */
    public void insert(Info info) {
        arr[hashCode(info.getKey())] = info;
    }

    /**
     * 开放地址法插入
     *
     * @param info
     */
    public void insertOpenAddress(Info info) {
        //获得关键字
        String key = info.getKey();
        //关键字所自定的哈希数
        int hashVal = hashCode(key);
        //如果这个索引已经被占用，而且里面是一个未被删除的数据
        while (arr[hashVal] != null && arr[hashVal].getName() != null) {
            //进行递加
            ++hashVal;
            //循环
            hashVal = hashVal % arr.length;
        }
        arr[hashVal] = info;
    }

    public Info find(String key) {
        return arr[hashCode(key)];
    }

    /**
     * 开放地址法查找
     *
     * @param key
     * @return
     */
    public Info findOpenAddress(String key) {
        int hashVal = hashCode(key);
        while (arr[hashVal] != null) {
            if (arr[hashVal].getKey().equals(key)) {
                return arr[hashVal];
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
    }

    /**
     * 开放地址法删除
     *
     * @param key
     * @return
     */
    public Info deleteOpenAddress(String key) {
        int hashVal = hashCode(key);
        while (arr[hashVal] != null) {
            if (arr[hashVal].getKey().equals(key)) {
                Info tmp = arr[hashVal];
                tmp.setName(null);
                return tmp;
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
    }

    /**
     * 哈希函数
     *
     * @param key
     * @return
     */
    public int hashCode(String key) {
//		int hashVal = 0;
//		for(int i = key.length() - 1; i >= 0; i--) {
//			int letter = key.charAt(i) - 96;
//			hashVal += letter;
//		}
//		return hashVal;

        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }
}
