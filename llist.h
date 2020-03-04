#ifndef LL_H
#define LL_H
/* The code above prevents this library from being included more than once */

struct LList
{
  struct LNode* head;
};

struct LNode {
  char* artistName;
  char* songName;
  double duration;
  struct LNode* next;
};

struct LList* createLList();

void printList(struct LList *list);

int addNode(struct LList *list, char* artistName, char* songName, double duration);

int remNode(struct LList *list, char* songName);

int addSortedDuration(struct LList *list, char* artistName, char* songName, double duration);

int addSortedName(struct LList *list, char* artistName, char* songName, double duration);

int clearList(struct LList *list);

#endif