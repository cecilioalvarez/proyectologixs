package es.logixs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.logixs.domain.Companies;
import es.logixs.domain.User;
import es.logixs.repository.mysql.CompaniesRepositoryMySQL;
import es.logixs.repository.mysql.UserRepositoryMySQL;

@ExtendWith(MockitoExtension.class)
public class UsersCompaniesServiceTest {
    @Mock
    public UserRepositoryMySQL userRepositoryMock;
    @Mock
    public CompaniesRepositoryMySQL companiesRepositoryMock;
    @InjectMocks
    public UsersCompanyService userCompaniesService;

    @Test
    public void findOneUserTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");

        when(userRepositoryMock.findOne("1A")).thenReturn(user1);

        User foundUser = userRepositoryMock.findOne("1A");

        assertEquals(user1, foundUser);
    }

    @Test
    public void findAllUsersTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");
        User user2 = new User("2A","Alexis","Fernandez","alexis@alexis.com");

        List<User> usersListMock = Arrays.asList(user1, user2);
        when(userRepositoryMock.findAll()).thenReturn(usersListMock);
        List<User> userListFinal = userCompaniesService.findAllUsers();

        verify(userRepositoryMock, times(1)).findAll();
        assertEquals(usersListMock, userListFinal);
    }

    @Test
    public void deleteUserTest() {

        User user = new User("1A");

        userCompaniesService.deleteUser(user);

        verify(userRepositoryMock, times(1)).delete(user);
    }

    @Test
    public void insertUserTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");

        when(userRepositoryMock.insert(user1)).thenReturn(user1);

        User insertedUser = userRepositoryMock.insert(user1);

        assertEquals(user1, insertedUser);
    }

    @Test
    public void insertCompaniesTest() {

        Companies company1 = new Companies("1A","ds12fsdf","asdafs23","PWC","324234d");

        when(companiesRepositoryMock.insert(company1)).thenReturn(company1);

        Companies insertedCompany = companiesRepositoryMock.insert(company1);

        assertEquals(company1, insertedCompany);
    }

    @Test
    public void findOneCompanyTest() {

        Companies company1 = new Companies("1A","ds12fsdf","asdafs23","PWC","324234d");


        when(companiesRepositoryMock.findOne("1A")).thenReturn(company1);

        Companies foundCompany = companiesRepositoryMock.findOne("1A");

        assertEquals(company1, foundCompany);
    }

    @Test
    public void findAllCompaniesTest() {

        Companies company1 = new Companies("1A","HFGAD2","ASDFAF2","PWC","asdfasdf2");
        Companies company2 = new Companies("2A","HFGDAD2","ASDFAAF2","PWC 2","asd2fasdf2");

        List<Companies> companiesListMock = Arrays.asList(company1, company2);
        when(companiesRepositoryMock.findAll()).thenReturn(companiesListMock);
        List<Companies> companiesListFinal = userCompaniesService.findAllCompanies();

        verify(companiesRepositoryMock, times(1)).findAll();
        assertEquals(companiesListMock, companiesListFinal);
    }

    @Test
    public void deleteCompaniesTest() {

        Companies company = new Companies("1A");

        userCompaniesService.deleteCompanies(company);

        verify(companiesRepositoryMock, times(1)).delete(company);
    }



}
