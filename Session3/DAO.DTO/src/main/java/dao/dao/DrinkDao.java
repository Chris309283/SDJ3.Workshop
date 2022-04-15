package dao.dao;

import dao.model.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DrinkDao implements DaoApi<Drink>
{
  private List<Drink> drinks = new ArrayList<>();

  public DrinkDao()
  {
    drinks.add(new Drink("Ginger Lemon","Hot ginger lemon",15.00,27));
    drinks.add(new Drink("TwoVladsOneCup", "Nice hot cup of shit",10000.0,1));
  }

  @Override public Optional<Drink> get(long id)
  {
    return Optional.ofNullable(drinks.get((int) id));
  }

  @Override public List<Drink> getAll()
  {
    return drinks;
  }

  @Override public void save(Drink drink)
  {
    drinks.add(drink);
  }

  @Override public void update(Drink drink, String[] params, double price,
      int qty)
  {
    drink.setName(Objects.requireNonNull(params[0],"Name can't be null"));
    drink.setDescription(params[1]);
    drink.setUnitPrice(price);
    drink.setQuantity(qty);
  }

  @Override public void delete(Drink drink)
  {
    drinks.remove(drink);
  }
}
