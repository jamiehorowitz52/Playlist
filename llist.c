#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "llist.h"

struct LList* createLList() {
  /* Create an empty linked list. */
  /* DO NOT MODIFY THIS CODE */
  struct LList* list = malloc(sizeof(struct LList));
  list->head = NULL;
  return list;
}

void printList(struct LList *list)
{
  /* Print a list from head to tail. */
  /* DO NOT MODIFY THIS CODE */
  struct LNode *entry;
   if(list == NULL || list->head == NULL) {
    printf(" printList: The playlist has not been initialized or empty!\n");
    return;
  }
  entry = list->head;
  printf("List Contents:\n");
  while(entry != NULL)
  {
    printf(" Artist  %s , song %s, duration %f\n", entry->artistName, entry->songName, entry->duration);
    entry = entry->next;
  }
}


int addNode(struct LList *list, char* artist, char* song, double duration){
  /*  Add a new entry to the linked list. 
      Return the index number of the new entry 
  */

	int counter = 0;

	if(list == NULL)
	{
		return -1;
	}
	
	if(list->head == NULL) //list is empty
	{
		list->head = (struct LNode*) malloc(sizeof(struct LNode)); //allocate space for new node
		list->head->artistName = artist;
		list->head->songName = song;
		list->head->duration = duration;
		list->head->next = NULL;
		return 0;  
	}

	else
	{
		struct LNode *ptr = list->head;
		
		while(ptr->next != NULL)
		{
			counter++;
			ptr = ptr->next;
		}

		struct LNode *node2 = (struct LNode*) malloc(sizeof(struct LNode));
		ptr->next = node2;
                node2->artistName = artist;
                node2->songName = song;
                node2->duration = duration;
 		node2->next = NULL;
		counter++;
	
		return counter;
	}



  return 0;
}


int remNode(struct LList *list, char* song)
{
  /*  Removes the song named "songName" from the list, if it exists.
      Returns the index of the element removed.
  */
	int index = 0;
	struct LNode *ptr = list->head;

	if(list == NULL)
        {
                return -1;
        }

	if(list->head == NULL) //list is empty, nothing to remove
	{
		return -1;
	}	

	if(ptr->next == NULL && (strcmp(list->head->songName, song) == 0) ) //if only one item in list
	{
		list->head = NULL;
		free(list->head);
		return 0;	
	}

	if(strcmp(song, ptr->songName) == 0)
	{
		list->head = ptr->next;
		free(list->head);	
		return 0;
	}

	while(ptr->next != NULL)
	{
		index++;
		if(strcmp(song, ptr->next->songName) == 0)
		{
			if(ptr->next->next == NULL)
			{
				ptr->next = NULL;
				free(ptr->next);
				return index;
			}

			ptr->next = ptr->next->next;
			free(ptr->next);	
			return index;
		}
		ptr = ptr->next;
	}

  	return -1;
}

int addSortedDuration(struct LList *list, char* artist, char* song, double duration)
{
  /*  Add a song to the list, sorted by duration in ascending order. 
      Returns the position of the new point.
  */

	int index = 0;

	if(list == NULL)
        {
                return -1;
        }
	
	if(list->head == NULL)
	{
		 list->head = (struct LNode*) malloc(sizeof(struct LNode));
		 list->head->artistName = artist;
                 list->head->songName = song;
                 list->head->duration = duration;
                 list->head->next = NULL;

		 return 0; 
	}

	else
	{	
		struct LNode *ptr = list->head;
		
		if(ptr->next == NULL)
		{
			struct LNode *newNode = (struct LNode*) malloc(sizeof(struct LNode));
        	        newNode->artistName = artist;
        	        newNode->songName = song;
        	        newNode->duration = duration;
        	        newNode->next = NULL;
			
			if(ptr->duration < newNode->duration)	
			{
				ptr->next = newNode;
				return 1;	
			}

			else
			{
				newNode->next = ptr;
				list->head = newNode;
				return 0;	
			}
		}
		
		else
		{
			struct LNode *node = (struct LNode*) malloc(sizeof(struct LNode));
			node->artistName = artist;
                        node->songName = song;
                        node->duration = duration;
                        node->next = NULL;	
		
			if(node->duration < ptr->duration)
			{
				node->next = ptr;
				list->head = node;
				return 0;
			}
			else
			{
				while(ptr->next != NULL)
				{
					index++;
					if(ptr->next->duration >= node->duration)
					{
						node->next = ptr->next;
						ptr->next = node;
						return index;
					}
					ptr = ptr->next;
				}
				ptr->next = node;
				index++;
				return index;
			}
		}
	}
	
  return -1;
}

int addSortedName(struct LList *list, char* artist, char* song, double duration)
{
  /*  Add a song to the list, sorted by the artist's name in alphabetical order. 
      Returns the position of the new point.
  */

	int index = 0;

	if(list == NULL)
        {
                return -1;
        }

	if(list->head == NULL)
	{
		 list->head = (struct LNode*) malloc(sizeof(struct LNode));
                 list->head->artistName = artist;
                 list->head->songName = song;
                 list->head->duration = duration;
                 list->head->next = NULL;

                 return 0; 
	}

	else
	{
		//case 1
		struct LNode *ptr = list->head;

		if(ptr->next == NULL)
		{
			struct LNode *newNode = (struct LNode*) malloc(sizeof(struct LNode));
                        newNode->artistName = artist;
                        newNode->songName = song;
                        newNode->duration = duration;
                        newNode->next = NULL;			

			if(strcmp(ptr->artistName, newNode->artistName) < 0)
			{
				ptr->next = newNode;
				return 1;
			}
			
			else
			{		
				newNode->next = ptr;
				list->head = newNode;
				return 0;
			}
		}	
		
		//case 2	
		else
		{
			struct LNode *node = (struct LNode*) malloc(sizeof(struct LNode));
                        node->artistName = artist;
                        node->songName = song;
                        node->duration = duration;
                        node->next = NULL;   
		
			if(strcmp(node->artistName,ptr->artistName)<0)	
			{		
				node->next = ptr;
				list->head = node;
				return 0;
			}

			else
			{
				while(ptr->next != NULL)
				{
					if(strcmp(list->head->artistName, node->artistName) == 0)
					{
						index++;
						while(strcmp(ptr->next->artistName, node->artistName) == 0)
						{
							index++;
							ptr = ptr->next;
						}	
						node->next = ptr->next;
						ptr->next = node;
						return index;	
					}
					index++;					
					
					if(strcmp(ptr->next->artistName, node->artistName) == 0)
					{
						while(strcmp(ptr->next->artistName, node->artistName) == 0)
						{
							if(ptr->next->next == NULL)
							{
								node->next = NULL;
								ptr->next = node;
								index++;				
								return index;
							}
							index ++;
							ptr = ptr->next;
						}
						node->next = ptr->next;
						ptr->next = node;
						return index;
					}
				
					else if(strcmp(ptr->next->artistName, node->artistName) > 0)
					{	
						node->next = ptr->next;
						ptr->next = node;
						return index;
					}
					ptr = ptr->next;
				}
				ptr->next = node;
				index++;
				return index;
			}					

		}
	}	
  return -1;
}

int clearList(struct LList *list) 
{
  /* Delete list and free all of the memory associate with its LNodes. */
  
	int counter = 0;
	struct LNode *ptr = list->head;

	if(list == NULL)
        {
                return -1;
        }

	while(ptr->next != NULL)
	{
		counter++;
		ptr = ptr->next;
		free(ptr);
	}
	
	counter++;
	list->head = NULL;	
	free(list->head);

	return counter;
}
