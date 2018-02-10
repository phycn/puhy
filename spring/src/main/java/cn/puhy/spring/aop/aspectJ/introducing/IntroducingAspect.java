package cn.puhy.spring.aop.aspectJ.introducing;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class IntroducingAspect {

	//为Phy添加PythonSkill接口，默认实现类为PythonStudy
	@DeclareParents(value="cn.puhy.spring.aop.aspectJ.introducing.Phy", defaultImpl=PythonStudy.class)
	public PythonSkill pythonSkill;
	
}
