package animal_kindom;

namespace Animals{

    // base class Animal
    class Animal{

     public void eat(Food f){

     }

    }


    class Carnivore extends Animal{

      public void eat(Meat f){

      }

    }

    class Herbivore extends Animal{

      public void eat(Plant f){

      }

    }

    class Omnivore extends Animal{

      public void eat(Food f){

      }
    }

}

namespace Food{

    // base class Food
    class Food{

    }

    class Meat extends Food{

    }

    class Plant extends Food{

    }

}