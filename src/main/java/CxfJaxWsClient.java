import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import net.webservicex.StockQuoteSoap;

public class CxfJaxWsClient {

	public static void main(String[] args) {

		CxfJaxWsClient cxfJaxWsClient = new CxfJaxWsClient();
		cxfJaxWsClient.invokeJaxWs();

	}
	
	private void invokeJaxWs() {

		StockQuoteSoap client = createCXFClient();
		String response = client.getQuote("test123");
		System.out.println(response);
		
	}
	
	protected StockQuoteSoap createCXFClient() {
	    // we use CXF to create a client for us as its easier than JAXWS and works
	    JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    System.out.println("createCXFClient().factory : " + factory);

	    factory.setServiceClass(StockQuoteSoap.class);
	    factory.setAddress("http://www.webservicex.net/stockquote.asmx");
	    return (StockQuoteSoap) factory.create();
	}


}
