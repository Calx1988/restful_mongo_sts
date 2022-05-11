package restful_mongo_sts.services.exceptions;

public class ObjNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjNotFoundException(String s) {
		super(s);
	}

}
