namespace java thrift.demo1.generalcode

service Hello{ 
	string helloString(1:string para) 
	i32 helloInt(1:i32 para) 
	bool helloBoolean(1:bool para) 
	void helloVoid() 
	string helloNull() 
}