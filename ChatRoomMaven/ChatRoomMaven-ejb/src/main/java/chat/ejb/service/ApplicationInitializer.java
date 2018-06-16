/* 
 * Copyright 2017 Bryan Daniel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package chat.ejb.service;

import chat.ejb.util.PropertiesUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * This singleton performs essential functions on start up of the application.
 *
 * @author Bryan Daniel
 */
@Singleton
@Startup
public class ApplicationInitializer {

    /**
     * This method executes after construction to load property values from
     * configuration files into memory.
     */
    @PostConstruct
    public void initialize() {
        try {
            PropertiesUtil.loadProperties();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ApplicationInitializer.class.getName()).log(Level.SEVERE,
                    "An exception was caught in the initialize method.", ex);
        }
    }
}
