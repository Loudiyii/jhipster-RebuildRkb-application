package com.rbuilde.myapp.model;

import java.util.List;
import java.util.Map;

public class GeneratorJhipsterUpdater {

    public static void updateGeneratorJhipster(GeneratorJhipster generatorJhipster, Map<String, Object> payload) {
        if (payload.containsKey("applicationType")) {
            generatorJhipster.setApplicationType((String) payload.get("applicationType"));
        }
        if (payload.containsKey("gitCompany")) {
            generatorJhipster.setGitCompany((String) payload.get("gitCompany"));
        }
        if (payload.containsKey("baseName")) {
            generatorJhipster.setBaseName((String) payload.get("baseName"));
        }
        if (payload.containsKey("packageName")) {
            generatorJhipster.setPackageName((String) payload.get("packageName"));
        }
        if (payload.containsKey("packageFolder")) {
            generatorJhipster.setPackageFolder((String) payload.get("packageFolder"));
        }
        if (payload.containsKey("serverPort")) {
            generatorJhipster.setServerPort((String) payload.get("serverPort"));
        }
        if (payload.containsKey("serviceDiscoveryType")) {
            generatorJhipster.setServiceDiscoveryType((boolean) payload.get("serviceDiscoveryType"));
        }
        if (payload.containsKey("authenticationType")) {
            generatorJhipster.setAuthenticationType((String) payload.get("authenticationType"));
        }
        if (payload.containsKey("cacheProvider")) {
            generatorJhipster.setCacheProvider((String) payload.get("cacheProvider"));
        }
        if (payload.containsKey("enableHibernateCache")) {
            generatorJhipster.setEnableHibernateCache((boolean) payload.get("enableHibernateCache"));
        }
        if (payload.containsKey("websocket")) {
            generatorJhipster.setWebsocket((boolean) payload.get("websocket"));
        }
        if (payload.containsKey("databaseType")) {
            generatorJhipster.setDatabaseType((String) payload.get("databaseType"));
        }
        if (payload.containsKey("devDatabaseType")) {
            generatorJhipster.setDevDatabaseType((String) payload.get("devDatabaseType"));
        }
        if (payload.containsKey("prodDatabaseType")) {
            generatorJhipster.setProdDatabaseType((String) payload.get("prodDatabaseType"));
        }
        if (payload.containsKey("searchEngine")) {
            generatorJhipster.setSearchEngine((boolean) payload.get("searchEngine"));
        }
        if (payload.containsKey("enableSwaggerCodegen")) {
            generatorJhipster.setEnableSwaggerCodegen((boolean) payload.get("enableSwaggerCodegen"));
        }
        if (payload.containsKey("messageBroker")) {
            generatorJhipster.setMessageBroker((boolean) payload.get("messageBroker"));
        }
        if (payload.containsKey("buildTool")) {
            generatorJhipster.setBuildTool((String) payload.get("buildTool"));
        }
        if (payload.containsKey("useSass")) {
            generatorJhipster.setUseSass((boolean) payload.get("useSass"));
        }
        if (payload.containsKey("clientPackageManager")) {
            generatorJhipster.setClientPackageManager((String) payload.get("clientPackageManager"));
        }
        if (payload.containsKey("testFrameworks")) {
            generatorJhipster.setTestFrameworks((List<String>) payload.get("testFrameworks"));
        }
        if (payload.containsKey("enableTranslation")) {
            generatorJhipster.setEnableTranslation((boolean) payload.get("enableTranslation"));
        }
        if (payload.containsKey("nativeLanguage")) {
            generatorJhipster.setNativeLanguage((String) payload.get("nativeLanguage"));
        }
        if (payload.containsKey("languages")) {
            generatorJhipster.setLanguages((List<String>) payload.get("languages"));
        }
        if (payload.containsKey("clientFramework")) {
            generatorJhipster.setClientFramework((String) payload.get("clientFramework"));
        }
        if (payload.containsKey("jhiPrefix")) {
            generatorJhipster.setJhiPrefix((String) payload.get("jhiPrefix"));
        }
        if (payload.containsKey("withAdminUi")) {
            generatorJhipster.setWithAdminUi((boolean) payload.get("withAdminUi"));
        }
        if (payload.containsKey("blueprints")) {
            generatorJhipster.setBlueprints((List<String>) payload.get("blueprints"));
        }
    }
}
