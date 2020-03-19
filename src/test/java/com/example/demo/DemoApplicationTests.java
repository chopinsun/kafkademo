package com.example.demo;

import com.example.demo.bean.KafkaSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {
    @Autowired
    private KafkaSender sender;

    @Test
    public void kafka() {
        for (int n = 0; n < 1000; n++) {
            System.out.println("------------->"+n);
            for (int i = 0; i < 2000; i++) {
                String msg = "{\"eventTime\":"+System.currentTimeMillis()+i+",\"eventVersion\":\"1.0.0\",\"service\":\"kafka\",\"serviceApiVersion\":\"v1\",\"eventName\":\"describeInstances\",\"eventSource\":\"apigw-stag.openapi.jdcloud.com\",\"eventId\":\"34865afc8dec347514b9ae76165f346253619a5ae0b593ced15a01e52ba66fd3\",\"eventType\":\"OpenAPI\",\"region\":\"cn-north-1\",\"ip\":null,\"userAgent\":\"JdcloudSdkNode/1.0.0 kafka/1.0.0\",\"errorCode\":\"\",\"errorMessage\":\"\",\"requestId\":\"bqp4h1jj3j22s6gqfoaqi5nsb8nagmkt\",\"plane\":\"Control\",\"classification\":\"Read\",\"account\":\"jcloudiaas2\",\"accessKeyId\":\"F72681368A7B67884B6565D63853C40D\",\"resources\":null,\"request\":{\"path\":\"/v1/regions/cn-north-1/instances\",\"method\":\"GET\",\"query\":\"pageNumber=1&pageSize=10\",\"body\":\"\"},\"response\":null,\"additionalEventData\":{\"caller\":\"console/kafka\"},\"identity\":{\"type\":\"JDService\",\"principal\":\"jcloudiaas2\",\"erpPrincipal\":null,\"account\":\"jcloudiaas2\",\"previousPrincipal\":null,\"invokedBy\":\"kafka\",\"mfa\":null,\"userName\":null},\"accountClassification\":\"jcloudiaas2Read\",\"accountPlane\":\"jcloudiaas2Control\"}";
                sender.sendMessage("AuditTrail.Audit.Tenant.Stag", msg);
                System.out.println("---->"+i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
