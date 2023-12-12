import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoLocationFinder {
    public static void main(String[] args) {
        String apiKey = null;
//  String apiKey = "AIzaSyB6teFVpUGbIeccQSWeK8gPLXTeq0atNzU11 "; //  rm- 11 to get APIKEY - create Google Cloud Platform Account and generate Key

        String zipCode = "431123"; // Replace with the desired ZIP code

        try {
            URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" + zipCode + "&key=" + apiKey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response to get the location details
            // (You may use a JSON parsing library like Jackson or Gson for better handling)
            String locationDetails = response.toString();
            System.out.println("Location details: " + locationDetails);

            // Extract relevant information from the JSON response, e.g., latitude and longitude

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
