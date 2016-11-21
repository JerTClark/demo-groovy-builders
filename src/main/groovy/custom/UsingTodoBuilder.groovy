package custom

builder = new TodoBuilder()
builder.build {
    Prepare_Vacation (start:"09/15", end:"10/15") {
        Reserve_Flight (on:"07/15", status:"done")
        Reserve_Hotel (on:"07/15")
        Reserve_Car (on:"07/15")
    }
    Purchase_New_PC {
        Install_Java
        Install_Node
        Install_Chrome {
            Sync_Accounts
        }
    }
}