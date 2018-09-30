package com.rozzer;

import com.google.common.collect.Sets;
import com.rozzer.common.CaseType;
import com.rozzer.common.Role;
import com.rozzer.common.WorkStatus;
import com.rozzer.manager.CoreObjectManager;
import com.rozzer.model.*;
import com.rozzer.validate.cucumber.CucumberCase;
import org.json.simple.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Set;


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
        Set<PLUser> plUsers = Sets.newHashSet();
        plUsers.add(newUser("Alex", "AA", Role.USER, "alex@mail.com"));
        plUsers.add(newUser("Ben", "BB", Role.USER, "ben@mail.com"));
        plUsers.add(newUser("Jack", "JJ", Role.USER, "jack@mail.com"));
        plUsers.add(newUser("Kim", "KK", Role.USER, "kim@mail.com"));
        plUsers.add(newUser("Michelle", "MM", Role.ADMIN, "michelle@mail.com"));
        plUsers.add(newUser("Romen", "RR", Role.ADMIN, "roman@mail.com"));
        plUsers.add(newUser("Rich", "RR", Role.ADMIN, "rich@mail.com"));
        plUsers.add(newUser("Kek", "kk", Role.ADMIN, "kek@mail.com"));
        plUsers.add(newUser("Sone", "SS", Role.ADMIN, "some@mail.com"));
        plUsers.add(newUser("ggg", "GG", Role.ADMIN, "ggg@mail.com"));
        plUsers.add(newUser("hhh", "HH", Role.ADMIN, "hhh@mail.com"));
        plUsers.add(newUser("qqq", "QQ", Role.ADMIN, "qqq@mail.com"));

        Set<Theme> themes = Sets.newHashSet();
        themes.add(newTheme("Spring", "Java language framework"));
        themes.add(newTheme("C#", "second most popular language"));
        themes.add(newTheme(".NET", "C# for web"));
        themes.add(newTheme("Java", "Popular language"));
        themes.add(newTheme("JS", "It's JS baby!"));
        themes.add(newTheme("C++", "Manage the memory"));
        themes.add(newTheme("C", "If wou want your OS"));


        Set<Comment> comments = Sets.newHashSet();
        comments.add(newComment(plUsers.stream().findAny().get(), "0 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "1 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "2 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "3 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "4 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "5 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "6 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "7 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "8 such code"));
        comments.add(newComment(plUsers.stream().findAny().get(), "9 such code"));

        Set<Project> projects = Sets.newHashSet();
        projects.add(newProject("Some C# Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get()));
        projects.add(newProject("Some C++ Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));
        projects.add(newProject("Some Java Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));
        projects.add(newProject("Some C Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));
        projects.add(newProject("Some JS Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));
        projects.add(newProject("Some .NET Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));
        projects.add(newProject("Some JAVA2 Project", plUsers, comments, themes.stream().filter(theme -> theme.getName().equals("Java")).findAny().get() ));

        newUserProject(projects.stream().findAny().get(), plUsers.stream().findAny().get(), "hackaton", "https://github.com/star-vars/hackaton", WorkStatus.STARTED);
        newUserProject(projects.stream().findAny().get(), plUsers.stream().findAny().get(), "hackaton", "https://github.com/star-vars/hackaton", WorkStatus.COMPLETED);
        newUserProject(projects.stream().findAny().get(), plUsers.stream().findAny().get(), "hackaton", "https://github.com/star-vars/hackaton", WorkStatus.FAILED);
        newUserProject(projects.stream().findAny().get(), plUsers.stream().findAny().get(), "hackaton", "https://github.com/star-vars/hackaton", WorkStatus.STARTED);

    }

    private Comment newComment(PLUser plUser, String such_code) {
        Comment comment = CoreObjectManager.getInstance().getManager(Comment.class).create();
        comment.setUser(plUser);
        comment.setText(such_code);
        comment.setDateTime(new Date(System.currentTimeMillis()));
        CoreObjectManager.getInstance().getManager(Comment.class).save(comment);
        return comment;
    }

    private void newUserProject(Project project, PLUser plUser, String repo, String repoUrl, WorkStatus started) {
        UserProject userProject = CoreObjectManager.getInstance().getManager(UserProject.class).create();
        userProject.setProject(project);
        userProject.setRepo(repo);
        userProject.setRepoUrl(repoUrl);
        userProject.setStatus(started);
        userProject.setUser(plUser);
        CoreObjectManager.getInstance().getManager(UserProject.class).save(userProject);
    }


    private Project newProject(String name, Set<PLUser> plUsers, Set<Comment> comments, Theme theme) {
        Project someProject = CoreObjectManager.getInstance().getManager(Project.class).create();
        someProject.setName(name);
        someProject.setSpecification("Something specification");

        for (int i = 0; i <= plUsers.size()-2; i++) {
            PLUser user = plUsers.stream().findAny().get();
            someProject.getLikers().add(user);
            plUsers.remove(user);
        }
        someProject.setCustomer(plUsers.stream().findAny().get());

        for (int i = 0; i <= comments.size()-5; i++) {
            Comment e = comments.stream().findAny().get();
            e.setProject(someProject);
            someProject.getComments().add(e);
            comments.remove(e);
        }

        someProject.getCases().add(newCase("Main Test Case", CaseType.USE_CASE));
        someProject.getCases().add(newCase("Some Test Case", CaseType.USE_CASE));
        someProject.getCases().add(newCase("Some Unit Test", CaseType.UNIT_TEST));
        someProject.getCases().add(newCase("Review", CaseType.CODE_STYLE));

        someProject.getThemes().add(theme);

        CoreObjectManager.getInstance().getManager(Project.class).save(someProject);
        return someProject;
    }

    private Theme newTheme(String name, String description) {
        Optional<Theme> first =
                CoreObjectManager.getInstance().getManager(Theme.class).getByName(name).stream().findFirst();
        Theme theme;
        if (first.isPresent()){
            theme = first.get();
        } else {
            theme = CoreObjectManager.getInstance().getManager(Theme.class).create();
        }
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
            aCase.setBody("TEST BODY");
        }  else if(type.equals(CaseType.UNIT_TEST)) {
            aCase.setBody("TEST BODY");
        } else if(type.equals(CaseType.CODE_STYLE)) {
            aCase.setBody("TEST BODY");
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
