package dao;



import dao.dao.DaoApi;
import dao.dao.DrinkDao;
import dao.model.Drink;

import java.util.Optional;

public class DaoDemo
{
  private static DaoApi<Drink> drinkDAO;

  public static void main(String[] args)
  {
    DrinkDao drinkDAO = new DrinkDao();

    drinkDAO.getAll().forEach(drink -> System.out.println(drink.getName() + "->" + drink.getUnitPrice()));

    Drink d1 = getDrink(0);
    System.out.println(d1.getName() + "->" + d1.getUnitPrice());
    drinkDAO.update(d1, new String[]{d1.getName(), d1.getDescription()},20.0,d1.getQuantity());

    Drink d2 = getDrink(1);
    drinkDAO.delete(d2);
    drinkDAO.save(new Drink("Piss", "Warm piss in a cup", 5.0,1));
    System.out.println("after updating deleting and saving");
    drinkDAO.getAll().forEach(drink -> System.out.println(drink.getName() + "->" + drink.getUnitPrice()));
  }

  private static Drink getDrink(long i)
  {
    Optional<Drink> drink = drinkDAO.get(i);
    return drink.orElseGet(()-> new Drink("Drink not found","unknown",0.0,0));
  }
}
