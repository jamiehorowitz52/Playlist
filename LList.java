public class LList {

  public LNode head;
  /* You may not add more data members to this class. */
  
  public void printList(){
    LNode entry = head;
    System.out.println("Playlist Contents:");
    while (entry != null) {
      System.out.printf("  %s song: %s, %f\n", entry.artistName, entry.songName, entry.duration);
      entry = entry.next;
    }
  }

  public int addNode(String name, String song, double duration){

    int counter = 0;  //keeps track of what node you are at in the list
    
    if(head == null)  //list is currently empty
    {
        head = new LNode(name, song, duration); //create new node 
        //set head = to new node
        return 0;     //return first index since only 1 node in the list at index 0
    }

    else  //list is not empty
    {
      LNode ptr = head;
       
          while (ptr.next != null) //iterate through list until end is reached
          {
            counter++;
            ptr = ptr.next;
          }
          LNode node2 = new LNode(name, song, duration); //create new node at the head
          ptr.next = node2;
          counter++; //increment counter for last item in list
          return counter;
  
    } 

    //return -1;  //if the list does not exist, return -1
  }

  public int remNode(String song){

    int index = 0;
    LNode ptr = head;

    if(head == null)  //list is currently empty, nothing to remove
    {
      return -1;
    }

    if(ptr.next == null) //if only one item in list;
    {
      head = null;
      return 0;
    }

    if(song.equals(ptr.songName)) //if you want to remove the first node in list
    {
       head = ptr.next; //set head to 2nd node
       return 0;
    }

    //if removing node in the middle 
    while(ptr.next!= null)  //iterate through the lsit
    {
      index++;
      if(song.equals(ptr.next.songName)) //if the ptr.next is at the node you are trying to remove 
      {
        if(ptr.next.next == (null)) //if the song you are searching for is at the end of the list
        {
          ptr.next = null;
          return index;
        }

        ptr.next = ptr.next.next; //skip the connection to the node you are removing
        return index;
      }
      ptr = ptr.next; 
    }

    return -1;  //song does not exit in list
  }

  public int addSortedDuration(String name, String song, double duration){
    
    int index = 0;  //keeps track of what node you are at in the list
    
    if(head == null)  //list is currently empty
    {
        head = new LNode(name, song, duration); //create new node and set head = to new node
        return 0;     //return first index since only 1 node in the list at index 0
    }
    else
    {
      LNode ptr = head;
      //2 cases:

          //case 1: there is only 1 song in the list
          if(ptr.next == null) 
          {
            LNode newNode = new LNode(name, song, duration);
            if(ptr.duration < newNode.duration) //if current node duration < new node duration
            {
              ptr.next = newNode; //add new node to end of list
              return 1; //sond added at index = 1, so 1 is returned
            }
            else //if current node duration > new node duration
            {
              newNode.next = ptr;
              head = newNode;
              return 0; //sond added at index = 0, so 0 is returned
            }
          }

          //case 2: there is more than 1 song in the list
          else
          {
            LNode node = new LNode(name, song, duration);

            //if the new node duration is shorter than the first node
            if(node.duration < ptr.duration)
            {
              node.next = ptr;
              head = node;  //new node needs to be inserted into first position
              return 0;
            }

            //if the new node duration is to be added between the 2nd index and the second to last index
            else{
              while(ptr.next != null)
              {
                index++;
                if(ptr.next.duration >= node.duration)
                {
                  node.next = ptr.next;
                  ptr.next = node; 
                  return index;
                }
                ptr = ptr.next; //increment ptr to next node
              }

              //end of list is reached and you should add the new node to the end of the list
              ptr.next = node; 
              index++;
              return index;
            }
          }
      }
  }

  public int addSortedName(String name, String song, double duration){
    //less than = higher up in alphabet
    
    int index = 0;  //keeps track of what node you are at in the list
    
    if(head == null)  //list is currently empty
    {
        head = new LNode(name, song, duration); //create new node and set head = to new node
        return 0;     //return first index since only 1 node in the list at index 0
    }
    else
    {
      LNode ptr = head;
      //2 cases:

          //case 1: there is only 1 song in the list
          if(ptr.next == null) 
          {
            LNode newNode = new LNode(name, song, duration);
            //if(ptr.duration < newNode.duration) //if current node duration < new node duration
            if((ptr.artistName).compareToIgnoreCase(newNode.artistName) < 0) //if current node name < new node name  (returns neg num)
            {
              ptr.next = newNode; //add new node to end of list
              return 1; //sond added at index = 1, so 1 is returned
            }
            else //if current node name > new node name
            {
              newNode.next = ptr;
              head = newNode;
              return 0; //sond added at index = 0, so 0 is returned
            }
          }

          //case 2: there is more than 1 song in the list
          else
          {
            LNode node = new LNode(name, song, duration);

            //if(node.duration < ptr.duration)  //if the new node duration is shorter than the first node
            //System.out.println("new song:" + node.artistName);
            //System.out.println("ptr song:" + ptr.artistName);
            if(node.artistName.compareToIgnoreCase(ptr.artistName) < 0) //if the new node name is less than the first node (returns neg num)
            {
              node.next = ptr;
              head = node;  //new node needs to be inserted into first position
              //System.out.print("this return");
              return 0;
            }

            //if the new node duration is to be added between the 2nd index and the second to last index
            else{
              while(ptr.next != null)
              {
                if(head.artistName.equals(node.artistName)) //if the first song in the list = name of the new node
                {
                  index++;
                  while(ptr.next.artistName.equals(node.artistName)) //continue for how many in a row 
                  {
                    index++;
                    ptr = ptr.next;
                  }
                  node.next = ptr.next;
                  ptr.next = node; 
                  return index;

                }

                index++;

                //if(ptr.next.duration >= node.duration)
                if(ptr.next.artistName.equals(node.artistName)) //if 2 songs are by the same artist
                {
                  while(ptr.next.artistName.equals(node.artistName)) //continue checking until last instance of same name is found
                  {
                    if(ptr.next.next == null) //if repeated node should be added at end of list
                    {
                      node.next= null;
                      ptr.next = node;
                      index ++;
                      return index;
                    }

                    index++;
                    ptr = ptr.next;
                  }
                  //index++;
                  node.next = ptr.next;
                  ptr.next = node; 
                  return index;

                }

                else if(ptr.next.artistName.compareToIgnoreCase(node.artistName) > 0) //if the new song should be inserted here
                {
                  node.next = ptr.next;
                  ptr.next = node; 
                  return index;
                }
                ptr = ptr.next; //increment ptr to next node
              }

              //end of list is reached and you should add the new node to the end of the list
              ptr.next = node; 
              index++;
              return index;
            }
          }
      }
  }

  public int clearList(){
    int counter = 0;

    LNode ptr = head;
       
          while (ptr.next != null) //iterate through list until end is reached
          {
            counter++;  //count how many items in the list
            ptr = ptr.next;
          }
       
    counter++;    //account for last node
    head = null; 
    return counter;  //return number of songs that were
  }

}
