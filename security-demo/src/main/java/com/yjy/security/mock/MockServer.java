package com.yjy.security.mock;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServer {

    public static void main(String[] args) throws IOException {
        configureFor(8062);
        removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");
    }

    private static void mock(String url, String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/" + fileName + ".txt");
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        stubFor(
                get(
                        urlPathEqualTo(url))
                        .willReturn(
                                aResponse()
                                        .withBody(content)
                                        .withStatus(200)));
    }
}
