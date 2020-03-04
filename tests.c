#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "llist.h"

/* You may NOT modify this file, except in the main() function. */

void sortTestName()
{
        /* Test adding songs in sorted order by artist. The numbers in parenthesis
                indicate the correct ordering to help you verify your function
                is correct.
        */
        /* DO NOT MODIFY THIS CODE */
        struct LList* playList = createLList();
        printf("Sort Test ARTIST NAME\n-------------\n");

        addSortedName(playList, "Freddie Mercury (3)", "The Show Must Go On", 4.05);
        addSortedName(playList, "Queen (7)", "Don't Stop Me Now", 3.29);
        addSortedName(playList, "Freddie Mercury (2)", "Love of my life", 3.36);
        addSortedName(playList, "Adelle (0)", "Hello", 6.07);
        addSortedName(playList, "P!nk (6)", "Try", 4.10);
        addSortedName(playList, "LuvBug (4)", "The best is yet to come", 3.21);
        addSortedName(playList, "Mihail (5)", "Who are you", 3.37);
        addSortedName(playList, "Coldplay (1)", "Paradise", 4.21);
        
        printf("The sorted playlist by Artist NAME is:\n\n-------------");
        printList(playList);
        printf("\n-------------\n\n");

        clearList(playList);
} 

void sortTestDuration()
{
         /* Test adding songs in sorted order by duration. The numbers in parenthesis
                indicate the correct ordering to help you verify your function
                is correct.
        */
        /* DO NOT MODIFY THIS CODE */
        struct LList* playList = createLList();
        printf("Sort Test DURATION\n-------------\n");

        addSortedDuration(playList, "Freddie Mercury (4)", "The Show Must Go On", 4.05);
        addSortedDuration(playList, "Queen (1)", "Don't Stop Me Now", 3.29);
        addSortedDuration(playList, "Freddie Mercury (2)", "Love of my life", 3.36);
        addSortedDuration(playList, "Adelle (7)", "Hello", 6.07);
        addSortedDuration(playList, "P!nk (5)", "Try", 4.10);
        addSortedDuration(playList, "LuvBug (0)", "The best is yet to come", 3.21);
        addSortedDuration(playList, "Mihail (3)", "Who are you", 3.37);
        addSortedDuration(playList, "Coldplay (6)", "Paradise", 4.21);
        
        printf("The sorted playlist by Sorted DURATION is:\n\n-------------");
        printList(playList);
        printf("\n-------------\n\n");

        clearList(playList);
} 

void remTest()
{
        /* DO NOT MODIFY THIS CODE */
        int position;
        struct LList* playList = createLList();

        printf("Test removing a point from an empty list\n-------------\n");
        position = remNode(playList,"Hello");
        if (position != -1){
                printf("ERROR: Not returning correct index in remove!\n");
        }
        printf("\n-------------\n\n");

        printf("Removal Test 1: \n-------------\n");
        addNode(playList, "LuvBug", "The best is yet to come", 3.21);
        printList(playList);
        position = remNode(playList, "The best is yet to come");
        if (position != 0){
                printf("ERROR: Not returning correct index in remove!\n");
        }
        printf("The playlist should be empty removing the head\n-------------");
        printList(playList);
        printf("\n-------------\n\n");

        printf("Removal Test 2: \n-------------\n");
        addNode(playList, "The Chainsmokers & Coldplay", "Something just like this", 4.08);
        addNode(playList, "Imagine Dragons", "Thunder", 3.08);
        addNode(playList, "The Chainsmokers & Coldplay", "Something just like this", 4.08);
        printList(playList);
        position = remNode(playList, "Something just like this");
        if (position != 0){
                printf("ERROR: Not returning correct index in remove!\n");
        }
        printf("The list should only have 2 songs:\n-------------");
        printList(playList);
        printf("\n-------------\n\n");

        printf("Removal Test 3: \n-------------\n");
        printList(playList);
        position = remNode(playList, "Something just like this");
        if(position != 1){
                printf("ERROR: Not returning correct index in remove!\n");
        }
        printf("The list should only have 1 song:\n-------------");
        printList(playList);
        printf("\n-------------\n\n"); 

         printf("Removal Test 4: \n-------------\n");
        printList(playList);
        position = remNode(playList, "Hello");
        if(position != -1){
                printf("ERROR: Not returning correct index in remove!\n");
        }
        printf("The list should only have 1 song:\n-------------");
        printList(playList);
        printf("\n-------------\n\n");      
} 

void clearTest()
{
        /* Create a playlist and then clear it out. */
        /* DO NOT MODIFY THIS CODE */
        struct LList *playList = createLList();

        printf("Clear Test\n-------------\n");
        addNode(playList, "Freddie Mercury", "The Show Must Go On", 4.05);
        addNode(playList, "Queen", "Don't Stop Me Now", 3.29);
        addNode(playList, "Freddie Mercury", "Love of my life", 3.36);
        printList(playList);
        printf("Clearing list...\n");
        clearList(playList);
        printf("Done clearning... should be empty\n");
        printList(playList);
        printf("\n-------------\n\n");
}

void addTestSimple()
{
        /* A simple test of addNode where the first entry is added manually*/
        /* DO NOT MODIFY THIS CODE */
        int i;
        struct LList* playList = createLList();
        struct LNode* song;
        
        printf("Add Test #1\n-------------\n");
        printf("creaing first entry...\n");
        song =  (struct LNode*) malloc(sizeof(struct LNode));
        song->artistName = "Imagine Dragons";
        song->songName = "Thunder";
        song->duration = 3.08;
        song->next = NULL;
        playList->head = song;
        printf("now adding more with function...\n");
        addNode(playList, "LuvBug", "The best is yet to come", 3.21);
        i = addNode(playList, "The Chainsmokers & Coldplay", "Something just like this", 4.08);
        if(i != 2){
                printf("ERROR: Not returning correct index in add!\n");
        }
        printf("Should print play list with 3 songs by: Imagine Dragons, LuvBug, and The Chainsmokers & Coldplay.\n");
        printList(playList);
        printf("\n-------------\n\n");
}

void addTestFull()
{
        /* Test adding to both an empty and partially filled list. */
        /* DO NOT MODIFY THIS CODE */
        struct LList *playList = createLList();

        printf("Add Test #2\n-------------\n");
        addNode(playList, "Freddie Mercury", "The Show Must Go On", 4.05);
        addNode(playList, "Queen", "Don't Stop Me Now", 3.29);
        addNode(playList, "Freddie Mercury", "Love of my life", 3.36);
        addNode(playList, "LuvBug", "The best is yet to come", 3.21);
        addNode(playList, "Adelle", "Hello", 6.07);
        addNode(playList, "P!nk", "Try", 4.10);
        addNode(playList, "LuvBug", "The best is yet to come", 3.21);
        addNode(playList, "Mihail", "Who are you", 3.37);
        addNode(playList, "Coldplay", "Paradise", 4.21);
        printList(playList);
        printf("\n-------------\n\n");
}


int main()
{
        
        // Verify adding elements works
 	addTestSimple();
        
        /*  Uncomment each of these to run the advanced tests   */
        addTestFull();
        remTest();
     	clearTest();
        sortTestName();
        sortTestDuration();      
        return 0;
}
