package edu.monmouth.hawkscode.security;

import java.io.File;

import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.saml.client.SAML2Client;
import org.pac4j.saml.config.SAML2Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class Pac4jConfig {

	@Bean
	public Config config() {
	final SAML2Configuration cfg = new SAML2Configuration(
			new ClassPathResource("static/config/samlKeystore.jks"), 
				"R#98Ytx5", 
				"R#98Ytx5",
				new ClassPathResource("static/config/federationmetadata.xml"));
		
		//cfg.setPostLogoutURL("");
		cfg.setServiceProviderEntityId("https://hawkscode.monmouth.edu/adfs/ls/");
		cfg.setUseNameQualifier(false);
		cfg.setServiceProviderMetadataPath(new File("/usr/share/tomcat/temp","hc-sp-metadata.xml").getAbsolutePath());
		
		//cfg.setServiceProviderMetadataResource(new FileSystemResource("/usr/share/tomcat/hawkscode-sp-metadata.xml"));
		
		cfg.setMaximumAuthenticationLifetime(28800);
		
		final SAML2Client saml2Client = new SAML2Client(cfg);
        
		final Clients clients = new Clients("https://hawkscode.monmouth.edu/callback", saml2Client);
		final Config config = new Config(clients);
		return config;
	}
//
//	/*
//	 * @Bean public Config config() {
//	 * 
//	 * final SAML2Configuration cfg = new SAML2Configuration(new
//	 * ClassPathResource("static/testconfig/samlKeystore.jks"), "pac4j-demo-passwd",
//	 * "pac4j-demo-passwd", new ClassPathResource("metadata-okta.xml"));
//	 * cfg.setMaximumAuthenticationLifetime(3600); cfg.setServiceProviderEntityId(
//	 * "https://hawkscode.monmouth.edu/callback?client_name=SAML2Client");
//	 * //cfg.setServiceProviderMetadataResource(new
//	 * ClassPathResource("static/testconfig/sp-metadata.xml")); final SAML2Client
//	 * saml2Client = new SAML2Client(cfg);
//	 * 
//	 * final Clients clients = new
//	 * Clients("https://hawkscode.monmouth.edu/callback", saml2Client);
//	 * 
//	 * return new Config(clients); }
//	 */

}
