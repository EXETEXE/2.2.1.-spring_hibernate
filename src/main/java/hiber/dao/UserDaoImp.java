package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserByCarData(String model, int series) {

        User result = null;
        Query query = sessionFactory.getCurrentSession().
                createQuery("from Car where model = :paramModel and series = :paramSeries");


        query.setParameter("paramModel", model).setParameter("paramSeries", series);

        Car car = (Car) query.getResultList().get(0);

        if (car != null) {
            result = car.getUser();
        }
        return result;
    }

}
