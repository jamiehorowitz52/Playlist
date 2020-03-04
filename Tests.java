//------------------------------------------------------------------------------*/

public class Tests {

  public static void addTestSimple() {
    LList list = new LList();
    int i = list.addNode("Adele", "hello", 3.2);

    //the list is empty so index should return 0 because new node added at the head
    if(i != 0)
    {
      System.out.println("FAILED: the list is empty but the index 0 is not returned");
    }

    //add a second song to the list
    i = list.addNode("Beatles", "Hey Jude", 3.7);

    //the list has one element so index returned should be 1 because new node added at the head
    if(i != 1)
    {
      System.out.println("FAILED: the list has 2 songs but the index 1 is not returned");
    }

     //add a third song to the list
     i = list.addNode("Beatles", "Help", 2.4);

     //the list has one element so index returned should be 1 because new node added at the head
     if(i != 2)
     {
       System.out.println("FAILED: the list has 3 songs but the index 2 is not returned");
     }
    
    else{
      System.out.println("addTestSimple SUCCEEDED"); 
    }
  }

  public static void addSortedDurationTest() {

    LList list = new LList();
    
    int i = list.addSortedDuration("Adele", "hello", 3.2);
    //the list is empty so index should return 0 because new node added at the head
    if(i != 0)
    {
      System.out.println("FAILED: the list is empty but the index 0 is not returned");
    }

    i = list.addSortedDuration("Beatles", "Hey Jude", 3.7);
    //second song of longer duration added, should be inserted at index 1
    if(i != 1)
    {
      System.out.println("3FAILED: song should be added at index 1 but the index 1 is not returned");
    }

    i = list.addSortedDuration("Beatles", "Help", 4.1);
     //third song of longer duration added, should be inserted at index 2
    if(i != 2)
    {
      System.out.println("FAILED: song should be added at index 2 but the index 2 is not returned");
    }

    i = list.addSortedDuration("Kanye", "Yikes", 4.4);
    //4th song of longer duration added, should be inserted at index 3
    if(i != 3)
    {
     //System.out.println(i);
     System.out.println("FAILED: song should be added at index 3 but the index 3 is not returned");
    }

    i = list.addSortedDuration("Lizo", "Soulmate", 2.1);

    //5th song of shortest duration added, should be inserted at index 0
    if(i != 0)
    {
     System.out.println("FAILED: song should be added at index 0 but the index 0 is not returned");
    }

    i = list.addSortedDuration("Jonas Brothers", "Sucker", 2.4);

    //6th song of second shortest duration added, should be inserted at index 1
    if(i != 1)
    {
      System.out.println(i);
     System.out.println(" 2 FAILED: song should be added at index 1 but the index 1 is not returned");
    }

    i = list.addSortedDuration("Jonas Brothers", "Rollercoaster", 4.0);

    //7th song of middle duration added, should be inserted at index 4
    if(i != 4)
    {
     System.out.println(i);
     System.out.println("FAILED: song should be added at index 4 but the index 4 is not returned");
    }

    i = list.addSortedDuration("Pompei", "One Republic", 4.0);

    //8th song of same duration as song at index 4, should be inserted at index 4
    if(i != 4)
    {
     //System.out.println("i: " + i);
     System.out.println("FAILED: song should be added at index 4 but the index 4 is not returned");
    }

    else{
      System.out.println("addSortedDurationTest SUCCEEDED"); 
    }

  }

  public static void addSortedNameTest() {

    LList list = new LList();

    int i = list.addSortedName("Adele", "hello", 3.2);
    //the list is empty so index should return 0 because new node added at the head
    if(i != 0)
    {
      System.out.println("FAILED: the list is empty but the index 0 is not returned");
    }

    i = list.addSortedName("Beatles", "Hey Jude", 3.7);
    //second song of longer duration added, should be inserted at index 1
    if(i != 1)
    {
      System.out.println(" 1 FAILED: song should be added at index 1 but the index 1 is not returned");
    }

    i = list.addSortedName("Drake", "Hotline Bling", 4.1);
     //third song of later in alphabet added, should be inserted at index 2
    if(i != 2)
    {
      System.out.println("FAILED: song should be added at index 2 but the index 2 is not returned");
    }

    i = list.addSortedName("Kanye", "Yikes", 4.4);
    //4th song of later in alphabet added, should be inserted at index 3
    if(i != 3)
    {
     //System.out.println(i);
     System.out.println("FAILED: song should be added at index 3 but the index 3 is not returned");
    }

    i = list.addSortedName("Abba", "Take a Chance", 2.1);

    //5th song of earliest in alphabet added, should be inserted at index 0
    if(i != 0)
    {
     System.out.println("FAILED: song should be added at index 0 but the index 0 is not returned");
    }

    i = list.addSortedName("AC/DC", "Highway to Hell", 2.4);

    //6th song of second earliest in alphabet added, should be inserted at index 1
    if(i != 1)
    {
     System.out.println(i);
     System.out.println("5 FAILED: song should be added at index 1 but the index 1 is not returned");
    }

    i = list.addSortedName("Cardi B", "I Like It", 4.0);

     //7th song of middle duration added, should be inserted at index 4
     if(i != 4)
     {
      System.out.println(i);
      System.out.println("FAILED: song should be added at index 4 but the index 4 is not returned");
     }

     i = list.addSortedName("Cardi B", "One Republic", 4.1);

    //8th song of same duration as song at index 4, should be inserted at index 5
    if(i != 5)
    {
     //list.printList();
     //System.out.println("i: " + i);
     System.out.println("FAILED: song should be added at index 5 but the index 5 is not returned");
    }

    i = list.addSortedName("Cardi B", "Rodeo", 4.1);

    //9th song of same duration as song at index 4, should be inserted at index 6
    if(i != 6)
    {
     //list.printList();
     
     System.out.println("FAILED: song should be added at index 6 but the index 6 is not returned");
    }

    //i = list.addSortedName("AC/DC", "Thunderstruck", 3.8);
    i = list.addSortedName("Abba", "Dancing Queen", 3.8);

    //10th song of same duration as song at index 0, should be inserted at index 1
    if(i != 1)
    {
     System.out.println("i: " + i);
     System.out.println("4 FAILED: song should be added at index 1 but the index 1 is not returned");
    }

    i = list.addSortedName("Kanye", "Jesus is King", 2.1);

    //11th song of same duration as song at index 9, should be inserted at index 10
    if(i != 10)
    {
     //System.out.println(i);
     System.out.println("FAILED: song should be added at index 10 but the index 10 is not returned");
    }

    else{
      //list.printList();
      System.out.println("addSortedNameTest SUCCEEDED"); 
    }

  }

  public static void remNodeTest()
  {
    //add three songs to list
    LList list = new LList();
    int i;

    i = list.remNode("The Climb");

    //should return -1  because trying to remove a song from an empty list;
    if(i != -1)
    {
     System.out.println("FAILED: song should not be able to be removed from empty list");
    }

    list.addNode("Miley Cirus", "The Climb", 4.4);
    i = list.remNode("The Climb");

    //should return 0  because trying to remove a song from index 0 of the list;
    if(i != 0)
    {
     System.out.println("FAILED: song should be removed from index 0 but was not");
    }

    list.addNode("Miley Cirus", "The Climb", 4.4);
    list.addNode("Kanye", "Jesus is King", 2.1);
    list.addNode("Cardi B", "Rodeo", 4.1);

    i = list.remNode("Jesus is King");

    //should return 1 because trying to remove a song from index 1 of the list;
    if(i != 1)
    {
     System.out.println("FAILED: song should be removed from index 1 but was not");
    }

    list.addNode("Kanye", "Jesus is King", 2.1);
    i = list.remNode("Jesus is King");

    //should return 2 because trying to remove a song from last index 2 of the list;
    if(i != 2)
    {
      //System.out.println(i);
      System.out.println("FAILED: song should be removed from index 2 but was not");
    }

    //trying to remove a node that doesn't exist in the list
    i = list.remNode("Jesus is King");

    if(i != -1)
    {
      //System.out.println(i);
      System.out.println("FAILED: should remove -1 because the song was not found in the list");
    }

    i = list.remNode("Rodeo");

    //should return 1 because trying to remove a song from last index 1 of the list;	
    if(i != 1)
    {
	System.out.println("FAILED: song should be removed from index 1 but was not");
    }

    else{
   //   list.printList();
      System.out.println("remNodeTest SUCCEEDED"); 
    }

  }


  public static void clearListTest()
  {
    //add three songs to list
    LList list = new LList();
    list.addNode("Adele", "hello", 3.2);
    list.addNode("Beatles", "Hey Jude", 3.7);
    list.addNode("Beatles", "Help", 2.4);

    //if all items in list are not counted for as cleared
    if(list.clearList() != 3)
    {
      System.out.println("the list has 3 songs but clear does not return 3");
    }

    else{
      System.out.println("clearListTest SUCCEEDED"); 
    }

  }
  
  public static void main (String[] argv) {
   
    addTestSimple();
    clearListTest();
    addSortedDurationTest();
    addSortedNameTest();
    remNodeTest();

  }
}
