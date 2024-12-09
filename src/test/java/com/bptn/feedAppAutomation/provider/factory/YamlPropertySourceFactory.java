package com.bptn.feedAppAutomation.provider.factory;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

public class YamlPropertySourceFactory implements PropertySourceFactory {

	// createPropertySource, which takes in the name of the property source
	// and an EncodedResource object representing the YAML file
	// This method uses the loadYamlIntoProperties method to convert the YAML file
	// into a Properties object,
	// and then returns a PropertiesPropertySource object containing the properties.

	@Override
	public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
		Properties loadedProperties = this.loadYamlIntoProperties(resource.getResource());

		return new PropertiesPropertySource((StringUtils.hasLength(name)) ? name : resource.getResource().getFilename(),
				loadedProperties);
	}
//The loadYamlIntoProperties method uses a YamlPropertiesFactoryBean class
//to convert the YAML file into a Properties object.

	private Properties loadYamlIntoProperties(Resource resource) {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(resource);
		factory.afterPropertiesSet();

		return factory.getObject();
	}
}