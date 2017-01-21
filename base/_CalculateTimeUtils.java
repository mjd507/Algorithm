public abstract class _CalculateTimeUtils {

	public void outputMethodTime(){
		long start = System.currentTimeMillis();
		method();
		long end = System.currentTimeMillis();
		System.out.println("执行时间为："+(end-start)+"ms");
	}

	public abstract void method() ;

}
