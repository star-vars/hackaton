package com.rozzer;

import com.rozzer.common.CaseType;
import com.rozzer.common.Role;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.model.Case;
import com.rozzer.model.PLUser;
import com.rozzer.model.Project;
import com.rozzer.model.Theme;
import com.rozzer.validate.cucumber.CucumberCase;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SuppressWarnings("SpringFacetCodeInspection")
@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        CoreObjectManager.setManagerFactory(new DBManagerFactory());
        SpringApplication.run(Application.class, args);
    }

    /**
     * write all beans in console.
     * @param ctx spring context
     * @return bean
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

            generationTestData();

        };
    }

    private void generationTestData() {
        Project someJavaProject = CoreObjectManager.getInstance().getManager(Project.class).create();
        someJavaProject.setName("Some Java Project");

        newUser("Alex", "AA", Role.USER, "alex@mail.com");
        newUser("Ben", "BB", Role.USER, "ben@mail.com");
        someJavaProject.getLikers().add(newUser("Jack", "JJ", Role.USER, "jack@mail.com"));
        someJavaProject.getLikers().add(newUser("Kim", "KK", Role.USER, "kim@mail.com"));
        someJavaProject.getLikers().add(newUser("Michelle", "MM", Role.ADMIN, "michelle@mail.com"));

        someJavaProject.setCustomer(newUser("David", "DD", Role.USER, "david@mail.com"));

        someJavaProject.getCases().add(newCase("Main Test Case", CaseType.USE_CASE));
        someJavaProject.getCases().add(newCase("Some Test Case", CaseType.USE_CASE));
        someJavaProject.getCases().add(newCase("Some Unit Test", CaseType.UNIT_TEST));
        someJavaProject.getCases().add(newCase("Review", CaseType.CODE_STYLE));


        newTheme("Spring", "Java language framework");
        newTheme("C#", "second most popular language");
        newTheme(".NET", "C# for web");

        someJavaProject.getThemes().add(newTheme("Java", "Popular language"));


        CoreObjectManager.getInstance().getManager(Project.class).save(someJavaProject);
    }

    private Theme newTheme(String name, String description) {
        Theme theme = CoreObjectManager.getInstance().getManager(Theme.class).create();
        theme.setName(name);
        theme.setDescription(description);
        CoreObjectManager.getInstance().getManager(Theme.class).save(theme);
        return theme;
    }

    private Case newCase(String name, CaseType type) {
        Case aCase = CoreObjectManager.getInstance().getManager(Case.class).create();
        aCase.setName(name);
        aCase.setType(type);
        if (type.equals(CaseType.USE_CASE)){
            aCase.setCaseBody(new CucumberCase());
        }  else if(type.equals(CaseType.UNIT_TEST)) {
            aCase.setCaseBody(new JSONObject());
        } else if(type.equals(CaseType.CODE_STYLE)) {
            aCase.setCaseBody(new JSONObject());
        }
        CoreObjectManager.getInstance().getManager(Case.class).save(aCase);
        return aCase;
    }

    private PLUser newUser(String name, String login, Role role, String mail) {
        PLUser plUser1 = CoreObjectManager.getInstance().getManager(PLUser.class).create();
        plUser1.setName(name);
        plUser1.setLogin(login);
        plUser1.setRole(role);
        plUser1.setMail(mail);
        CoreObjectManager.getInstance().getManager(PLUser.class).save(plUser1);
        return plUser1;
    }

}
