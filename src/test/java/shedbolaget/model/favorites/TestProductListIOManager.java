package shedbolaget.model.favorites;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestProductListIOManager {
    ProductIdListsIOManager manager = ProductIdListsIOManager.getInstance();

    @Test
    public void testGetInstance() {
        manager.clear();
        Assert.assertNotNull(manager);
    }


    @Test
    public void testLoadAllLists() {
        manager.clear();
        SavableProductIdList list1 = RandomListCreator.createList();
        SavableProductIdList list2 = RandomListCreator.createList();
        manager.addList(list1);
        manager.addList(list2);
        manager.saveAllLists();
        manager.loadAllLists();
        List<SavableProductIdList> listList = manager.getLists();

        Assert.assertEquals(list1, listList.get(0));
        Assert.assertEquals(list2, listList.get(1));
    }

    @Test
    public void testGetList() {
        manager.clear();
        SavableProductIdList list = RandomListCreator.createList();
        manager.addList(list);
        SavableProductIdList testList = manager.getList(list.getName());

        Assert.assertEquals(list, testList);
    }

    @Test
    public void testGetLists() {
        manager.clear();
        List<SavableProductIdList> lists = RandomListCreator.createLists();
        manager.addLists(lists);
        List<SavableProductIdList> testLists = manager.getLists();
        Assert.assertEquals(testLists.size(), lists.size());

        for (int i = 0; i < testLists.size(); i++)
            Assert.assertEquals(testLists.get(i), lists.get(i));
    }

    @Test
    public void testAddList() {
        SavableProductIdList testList = RandomListCreator.createList();
        manager.addList(testList);
        SavableProductIdList addedList = manager.getList(testList.getName());

        Assert.assertEquals(addedList, testList);
    }

    @Test
    public void testAddListWithSameName() {
        manager.clear();
        SavableProductIdList testList = RandomListCreator.createList();
        manager.addList(testList);
        Assert.assertEquals(1, manager.getSize());
        manager.addList(testList);
        Assert.assertEquals(1, manager.getSize());
    }


    @Test
    public void testRemoveListByObject() {
        SavableProductIdList testList = RandomListCreator.createList();
        manager.addList(testList);
        Assert.assertNotNull(manager.getList(testList.getName()));
        manager.removeList(testList);
        Assert.assertNull(manager.getList(testList.getName()));
    }

    @Test
    public void testRemoveListByName() {
        SavableProductIdList testList = RandomListCreator.createList();
        manager.addList(testList);
        Assert.assertNotNull(manager.getList(testList.getName()));
        manager.removeList(testList.getName());
        Assert.assertNull(manager.getList(testList.getName()));
    }

    @Test
    public void testRemoveListThatDontExist() {
        manager.clear();
        manager.removeList("someName");
        SavableProductIdList list = RandomListCreator.createList();
        manager.removeList(list);
    }

    @Test
    public void testGetSize() {
        for (int i = 0; i < 100; i++) {
            manager.clear();
            List<SavableProductIdList> testList = RandomListCreator.createLists();
            manager.addLists(testList);
            if (manager.getSize() != testList.size()) {
                System.out.println("FEEEl");
            }
            Assert.assertEquals(manager.getSize(), testList.size());
        }
    }

    static class RandomListCreator {
        static List<String> takenNames = new ArrayList<>();
        static Random rand = new Random();
        static List<SavableProductIdList> createLists() {
            int amount = rand.nextInt(10);
            List<SavableProductIdList> res = createLists(amount);
            return res;
        }

        static List<SavableProductIdList> createLists(int amount) {
            List<SavableProductIdList> res = new ArrayList<>();
            for (int i = 0; i < amount; i++)
                res.add(createList());

            return res;
        }


        static SavableProductIdList createList() {
            String name = randomUniqueNameGenerator();
            SavableProductIdList list = new SavableProductIdList(name);
            int amountOfProducts = rand.nextInt(20);
            for (int i = 0; i < amountOfProducts; i++)
                list.addProductId(getRandomProductId());

            return list;
        }


        private static int getRandomProductId() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 7; i++)
                builder.append(rand.nextInt(9));

            return Integer.parseInt(builder.toString());
        }

        private static String randomUniqueNameGenerator() {
            int lengthOfName = 0;
            while (lengthOfName == 0)
                lengthOfName = rand.nextInt(10);

            StringBuilder name = new StringBuilder();
            do {
                for (int i = 0; i < lengthOfName; i++) {
                    name.append(rand.nextInt(9));

                }
            } while (takenNames.contains(name.toString()));

            takenNames.add(name.toString());
            return name.toString();
        }


    }


}
