import com.nacorpio.ssl.utilities.ZetaPattern;


public final class zeta {

	public static void main(String[] args) {
		ZetaPattern zeta = new ZetaPattern("{-d:5}");
		String result = zeta.compile();
		System.out.println(zeta);	
	}

}
