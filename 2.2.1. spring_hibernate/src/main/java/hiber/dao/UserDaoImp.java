package hiber.dao;


import hiber.model.Car;
import hiber.model.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user.getCar());
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();

   }

   @Override
   public User findCarByModelAndSeries(String carModel, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user" +
                      " WHERE user.car.model =: model AND user.car.series=: series")
              .setParameter("model", carModel)
              .setParameter("series", series);

      return query.getSingleResult();
   }

   @Override
   public void cleanUsersAndCarsTables() {

         Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM User");
         query.executeUpdate();
         query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Car");
         query.executeUpdate();

   }
}
