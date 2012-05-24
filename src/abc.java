
public class abc {
	createImageIcon(String path,
            String description) {
java.net.URL imgURL = TextSamplerDemo.class.getResource(path);
if (imgURL != null) {
return new ImageIcon(imgURL, description);
} else {
System.err.println("Couldn't find file: " + path);
return null;
}
}
}
