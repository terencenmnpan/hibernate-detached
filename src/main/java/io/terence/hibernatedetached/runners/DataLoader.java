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
        test.setText("aaa");
        testRepository.save(test);
        //Create new Test object with same Pk, null version
        Test test2 = test.cloneMe();
        //You will see below Exception in log
        //Detached entity with generated id '1' has an uninitialized version value 'null' :
        //uncomment below to fix exception
        //test2.setPk(null);
        testRepository.save(test2);
        //Same as above, but just showing code with creating an object with the same pk
        Test test3 = new Test();
        test3.setPk(1L);
        test3.setText("aaa");
        //uncomment below to fix exception
        //test3.setPk(null);
        testRepository.save(test3);
    }
}
