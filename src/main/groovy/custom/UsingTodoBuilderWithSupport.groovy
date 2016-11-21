package custom
builder = new TodoBuilderWithSupport()

builder.build {
    Learn_Groovy(start:"Long ago", end:"Soon") {
        Read_About_MOP(on:"06/15", status:"done")
        Read_About_Builders(on:"06/15")
    }
    Get_A_Wonderful_Job(start: "ASAP", end:"ASAP") {
        Send_Out_5_Applications(on:"06/15",status:"done")
        Send_Out_5_More_Applications(on:"06/15") {
            Compile_A_List_Of_Jobs(on:"06/15")
            Apply_To_Jobs(on:"06/15")
        }
    }
}