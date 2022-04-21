package q49;

public class Build {
	public int length;
    public int width;
	public Build(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}
    public String builder(int blength, int bwidth, int count) throws ShortageException, TendorException{
    	if(length%blength==0&&width%bwidth==0&&length*width<=blength*bwidth*count)
    		return "Builder!!";
    	if(length%blength==0&&width%bwidth==0&&length*width>blength*bwidth*count)
    		throw new ShortageException("Need more bricks");
    	if((length%blength!=0||width%bwidth!=0)&&length*width<=blength*bwidth*count)
    		throw new TendorException("Building dimension mismatched");
    	if((length%blength!=0||width%bwidth!=0)&&length*width>blength*bwidth*count)
		throw new ShortageException("Need more bricks with dimension mismatched");
    	return "Builder!!";
    }
    public static void main(String[] args) throws ShortageException, TendorException {
    	Build build = new Build(100, 100);
    	System.out.println(build.builder(10,10,100));
    	System.out.println(build.builder(10,10,50));
	}
}
@SuppressWarnings("serial")
class ShortageException extends Exception{
	ShortageException(String msg){
        super(msg);
	}
}
@SuppressWarnings("serial")
class TendorException extends Exception{
	TendorException (String msg){
        super(msg);
    }
}