package guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceLogger implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("### DataSource URL: " + dataSource.getConnection().getMetaData().getURL());
    }
}
