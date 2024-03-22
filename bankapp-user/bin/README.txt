Package	
	What?
	Named collection of related classes and interfaces
	(It is a folder structure)
	Why?
		Organize the code
		Easy to manage , search
		To separate the code done for different modules.
		Avoid naming conflicts.
		
		Best Practice
		=============
		It is recommended to keep every java class in a package
		All built in classes are in some package
		NO class MUST be written outside package
		
	How?
		using package statement;
	
	Naming convention
		1) It is written in small case
		2) it is should be in reverse order of domain
		
		com.vwits - 
		
		
		
		com.vwits.bankapp.entity; - Account
		com.vwits.bankapp.view.impl; - AccountConsoleView
		com.vwits.bankapp.dao.impl; - AccountArrayDaoImpl
		com.vwits.bankapp.web.response- AccountResponse
		com.vwits.bankapp.util - ModelMapper
		
		
		com.vwits.ems.entity - Employee
		
		
		
		com.abc.sms.entity - Student
		
		
		
		
		A class which is inside a package to use it outside the package we MUST 
		"import" it. 
		
		===================
		access specifiers
		===================
		public		this is least strict. hence accessible anywhere
		
		protected	
		
		default		it is default access specifier, accessible in the same package.
		
		private	    this is most strict. hence accessible only within same class in which it is 
					declared
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
