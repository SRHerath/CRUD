package com.example.testing.Sql;

public class ItemModel {

        private String itemCode;
        private String itemDes;
        private String itemQuan;
        private int id;

        // creating getter and setter methods
        public String getItemCode() { return itemCode; }

        public void setItemCode(String itemCode)
        {
            this.itemCode = itemCode;
        }

        public String getItemDes()
        {
            return itemDes;
        }

        public void setItemDes(String itemDes)
        {
            this.itemDes = itemDes;
        }

        public String getItemQuan() { return itemQuan; }

        public void setItemQuan(String itemQuan)
        {
            this.itemQuan = itemQuan;
        }


        public int getId() { return id; }

        public void setId(int id) { this.id = id; }

        // constructor
        public ItemModel(String itemCode,
                           String itemDes,
                           String itemQuan)
        {
            this.itemCode = itemCode;
            this.itemDes = itemDes;
            this.itemQuan = itemQuan;
        }


}
