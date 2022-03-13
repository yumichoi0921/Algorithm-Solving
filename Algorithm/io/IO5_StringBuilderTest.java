package Algorithm.io;


public class IO5_StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("hello ");
		sb.append("ssafy");
		sb.append("!!");
		sb.setLength(sb.length()-2);
		System.out.println(sb.toString());
	}
}
