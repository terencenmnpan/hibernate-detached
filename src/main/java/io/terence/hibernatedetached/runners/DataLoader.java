package io.terence.hibernatedetached.runners;

import io.terence.hibernatedetached.entities.Test;
import io.terence.hibernatedetached.repositories.TestRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final TestRepository testRepository;

    public DataLoader(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        //Create new Test object with a Pk
        Test test = new Test();
        test.setPk(1L);
        test.setText("aaa");
        testRepository.save(test);
        //Create new Test object with same Pk, null version
        Test test2 = test.cloneMe();
        //You will see below Exception in log
        //Detached entity with generated id '1' has an uninitialized version value 'null' :
        testRepository.save(test2);
    }
}
