package pl.aras.accuweather.service;

import org.springframework.stereotype.Service;
import pl.aras.accuweather.exception.IntegrationException;
import pl.aras.accuweather.exception.InternalException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.GZIPInputStream;

@Service
public class AccuweatherServiceImpl implements AccuweatherService {

    @Override
    public byte[] getDecodedByteResponseFromGivenUrl(String apiName, String destinationUrl) throws InternalException, IntegrationException {
        URI url = URI.create(destinationUrl);
        HttpRequest getRequest = HttpRequest.newBuilder(url).GET().headers("Accept-Encoding", "gzip").build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<byte[]> response = null;
        try {
            response = client.send(getRequest, HttpResponse.BodyHandlers.ofByteArray());
        } catch (IOException | InterruptedException e) {
            throw new InternalException(apiName, e);
        }
        if (response.statusCode() == 200) {
            try (GZIPInputStream gzis = new GZIPInputStream(new ByteArrayInputStream(response.body()))) {
                byte[] buffer = new byte[1024];
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    int len;
                    while ((len = gzis.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    return out.toByteArray();
                }
            } catch (IOException e) {
                throw new InternalException(apiName, e);
            }
        } else {
            throw new IntegrationException(response.statusCode(), apiName);
        }
    }
}
