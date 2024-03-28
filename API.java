import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
<<<<<<< HEAD
import java.nio.charset.StandardCharsets;
=======
>>>>>>> 15f6ff06e6cf7db66ab0a9326fd1a3cd3a085400

public class API {
    public static String translate(String langFrom, String langTo, String text) {
        try {
            String urlStr = "https://script.google.com/macros/s/AKfycbyy9PjjDO1fKR2kV5wI0i8I-mZDLSK0zOHKPUQDwk0rk-g5QCHUueAgiNIm-fhIFJMa_A/exec"
                    +
<<<<<<< HEAD
                    "?q=" + URLEncoder.encode(text, StandardCharsets.UTF_8) +
=======
                    "?q=" + URLEncoder.encode(text, "UTF-8") +
>>>>>>> 15f6ff06e6cf7db66ab0a9326fd1a3cd3a085400
                    "&target=" + langTo +
                    "&source=" + langFrom;
            URL url = new URL(urlStr);
            StringBuilder response = new StringBuilder();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (IOException e) {
            return ("Vui lòng kiểm tra kết nối Internet!");
        }
    }
}