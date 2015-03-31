package cutout.java.util;

import cutout.java.ParameterizedTemplate;
import cutout.java.Renderer;
import cutout.java.TextTemplate;

public abstract class Template_templateClass extends ParameterizedTemplate<Template_templateClass.Params> {
	
	public final Parts parts;
	
	protected Template_templateClass(TextTemplate packageName, Template_partClass partClass) {
		
		this.parts = new Parts(packageName, partClass);
	}
	
	static public final class Parts {
		
		public final TextTemplate packageName;
		public final Template_partClass partClass;
		
		private Parts(

			TextTemplate packageName,
			Template_partClass partClass) {
			
			this.packageName = packageName;
			this.partClass = partClass;
		}
	}
	
	public Params.Builder params() {
		
		return new Params.Builder();
	}
	
	static public final class Params {
		
		public final String packageName;
		public final Renderer partClass;
		
		private Params(String packageName, Renderer partClass) {
			
			this.packageName = packageName;
			this.partClass = partClass;
		}
	
		static public final class Builder {
			
			private String packageName;
			private Renderer partClass;
			
			public Builder packageName(String value) {
				
				this.packageName = value;
				return this;
			}
			
			public Builder partClass(Renderer value) {
				
				this.partClass = value;
				return this;
			}
			
			public Params build() {
				
				return new Params(packageName, partClass);
			}
		}
	}
	
	static public abstract class Template_partClass extends ParameterizedTemplate<Template_partClass.Params> {
	
		public final Parts parts;
		
		protected Template_partClass(
				
			TextTemplate className, 
			Template_constructor constructor, 
			Template_partsClass partsClass, 
			Template_paramsClass paramsClass,
			Template_partsClassesMembers partsClassesMembers) {
			
			this.parts = new Parts(className, constructor, partsClass, paramsClass, partsClassesMembers);
		}
		
		static public final class Parts {
			
			public final TextTemplate className;
			public final Template_constructor constructor;
			public final Template_partsClass partsClass;
			public final Template_paramsClass paramsClass;
			public final Template_partsClassesMembers partsClassesMembers;
			
			private Parts(
				TextTemplate className, 
				Template_constructor constructor, 
				Template_partsClass partsClass, 
				Template_paramsClass paramsClass,
				Template_partsClassesMembers partsClassesMembers) {
				
				this.className = className;
				this.constructor = constructor;
				this.partsClass = partsClass;
				this.paramsClass = paramsClass;
				this.partsClassesMembers = partsClassesMembers;
			}
		}
		
		public Params.Builder params() {
	
			return new Params.Builder();
		}
		
		static public final class Params {
			
			public final String className;
			public final Renderer constructor;
			public final Renderer partsClass;
			public final Renderer paramsClass;
			public final Renderer partsClassesMembers;
			
			private Params(
				String className, 
				Renderer constructor,
				Renderer partsClass, 
				Renderer paramsClass,
				Renderer partsClassesMembers) {
				
				this.className = className;
				this.constructor = constructor;
				this.partsClass = partsClass;
				this.paramsClass = paramsClass;
				this.partsClassesMembers = partsClassesMembers;
			}
			
			static public final class Builder {
				
				private String className;
				private Renderer constructor;
				private Renderer partsClass;
				private Renderer paramsClass;
				private Renderer partsClassesMembers;
				
				public Builder className(String value) {
					
					this.className = value;
					return this;
				}
				
				public Builder constructor(Renderer value) {
					
					this.constructor = value;
					return this;
				}
				
				public Builder partsClass(Renderer value) {
					
					this.partsClass = value;
					return this;
				}
	
				
				public Builder paramsClass(Renderer value) {
					
					this.paramsClass = value;
					return this;
				}
	
				
				public Builder partsClassesMembers(Renderer value) {
					
					this.partsClassesMembers = value;
					return this;
				}
				
				public Params build() {
					
					return new Params(className, constructor, partsClass, paramsClass, partsClassesMembers);
				}
			}
		}
		
		static public abstract class Template_constructor extends ParameterizedTemplate<Template_constructor.Params> {
			
			public final Parts parts;
			
			protected Template_constructor(TextTemplate className, Template_constructor.Template_params params, Template_constructor.Template_partsConstructorArgs partsConstructorArgs) {
				
				this.parts = new Parts(className, params, partsConstructorArgs);
			}
			
			static public final class Parts {
				
				public final TextTemplate className;
				public final Template_constructor.Template_params params; 
				public final Template_constructor.Template_partsConstructorArgs partsConstructorArgs;
				
				private Parts(TextTemplate className, Template_constructor.Template_params params, Template_constructor.Template_partsConstructorArgs partsConstructorArgs) {
					
					this.className = className;
					this.params = params;
					this.partsConstructorArgs = partsConstructorArgs;
				}
			}
	
			public Params.Builder params() {
	
				return new Params.Builder();
			}		
			
			static public final class Params {
			
				public final String className;
				public final Renderer params; 
				public final Renderer partsConstructorArgs;
				
				private Params(String className, Renderer params, Renderer partsConstructorArgs) {
					
					this.className = className;
					this.params = params;
					this.partsConstructorArgs = partsConstructorArgs;
				}
			
				static public final class Builder {
					
					private String className;
					private Renderer params; 
					private Renderer partsConstructorArgs;
					
					public Template_constructor.Params.Builder className(String value) {
						
						this.className = value;
						return this;
					}
					
					public Template_constructor.Params.Builder params(Renderer value) {
						
						this.params = value;
						return this;
					}
					
					public Template_constructor.Params.Builder partsConstructorArgs(Renderer value) {
						
						this.partsConstructorArgs = value;
						return this;
					}
					
					public Template_constructor.Params build() {
						
						return new Params(className, params, partsConstructorArgs);
					}
				}
			}
			
			static public abstract class Template_params extends ParameterizedTemplate<Template_params.Params> { 
				
				public final Parts parts;
				
				protected Template_params(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
					
					this.parts = new Parts(type, name, delimiter);
				}
				
				static public final class Parts {
					
					public final TextTemplate type;
					public final TextTemplate name; 
					public final TextTemplate delimiter;
					
					private Parts(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
						
						this.type = type;
						this.name = name;
						this.delimiter = delimiter;
					}
				}
					
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final String type;
					public final String name; 
					public final String delimiter;
					
					private Params(String type, String name, String delimiter) {
						
						this.type = type;
						this.name = name;
						this.delimiter = delimiter;
					}
				
					static public final class Builder {
						
						private String type;
						private String name; 
						private String delimiter;
						
						public Builder type(String value) {
							
							this.type = value;
							return this;
						}
						
						public Builder name(String value) {
							
							this.name = value;
							return this;
						}
						
						public Builder delimiter(String value) {
							
							this.delimiter = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(type, name, delimiter);
						}
					}
				}
			}
			
			static public abstract class Template_partsConstructorArgs  extends ParameterizedTemplate<Template_partsConstructorArgs.Params> {
				
				public final Parts parts;
				
				protected Template_partsConstructorArgs(TextTemplate value, TextTemplate delimiter) {
					
					this.parts = new Parts(value, delimiter);
				}
				
				static public final class Parts {
					
					public final TextTemplate value; 
					public final TextTemplate delimiter;
					
					private Parts(TextTemplate value, TextTemplate delimiter) {
						
						this.value = value;
						this.delimiter = delimiter;
					}
				}
					
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final String value; 
					public final String delimiter;
					
					private Params(String value, String delimiter) {
						
						this.value = value;
						this.delimiter = delimiter;
					}
				
					static public final class Builder {
						
						private String value; 
						private String delimiter;
						
						public Builder value(String value) {
							
							this.value = value;
							return this;
						}
						
						public Builder delimiter(String value) {
							
							this.delimiter = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(value, delimiter);
						}
					}
				}
			}
		}
		
		static public abstract class Template_partsClass extends ParameterizedTemplate<Template_partsClass.Params> {
			
			public final Parts parts;
			
			protected Template_partsClass(Template_fields fields, Template_constructor constructor) {
				
				this.parts = new Parts(fields, constructor);
			}
			
			static public final class Parts {
				
				public final Template_fields fields; 
				public final Template_constructor constructor;
				
				private Parts(Template_fields fields, Template_constructor constructor) {
					
					this.fields = fields;
					this.constructor = constructor;
				}
			}
	
			public Params.Builder params() {
	
				return new Params.Builder();
			}		
			
			static public final class Params {
			
				public final Renderer fields; 
				public final Renderer constructor;
				
				private Params(Renderer fields, Renderer constructor) {
					
					this.fields = fields;
					this.constructor = constructor;
				}
			
				static public final class Builder {
					
					private Renderer fields; 
					private Renderer constructor;
					
					public Params.Builder fields(Renderer value) {
						
						this.fields = value;
						return this;
					}
					
					public Params.Builder constructor(Renderer value) {
						
						this.constructor = value;
						return this;
					}
					
					public Params build() {
						
						return new Params(fields, constructor);
					}
				}
			}
			
			static public abstract class Template_fields extends ParameterizedTemplate<Template_fields.Params> { 
				
				public final Parts parts;
				
				protected Template_fields(TextTemplate type, TextTemplate name) {
					
					this.parts = new Parts(type, name);
				}
				
				static public final class Parts {
					
					public final TextTemplate type;
					public final TextTemplate name; 
					
					private Parts(TextTemplate type, TextTemplate name) {
						
						this.type = type;
						this.name = name;
					}
				}
					
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final String type;
					public final String name; 
					
					private Params(String type, String name) {
						
						this.type = type;
						this.name = name;
					}
				
					static public final class Builder {
						
						private String type;
						private String name; 
						
						public Builder type(String value) {
							
							this.type = value;
							return this;
						}
						
						public Builder name(String value) {
							
							this.name = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(type, name);
						}
					}
				}
			}
			
			static public abstract class Template_constructor extends ParameterizedTemplate<Template_constructor.Params> {
				
				public final Template_constructor.Parts parts;
				
				protected Template_constructor(Template_params params, Template_fieldAssigments fieldAssigments) {
					
					this.parts = new Parts(params, fieldAssigments);
				}
				
				static public final class Parts {
					
					public final Template_params params; 
					public final Template_fieldAssigments fieldAssigments;
					
					private Parts(Template_params params, Template_fieldAssigments fieldAssigments) {
						
						this.params = params;
						this.fieldAssigments = fieldAssigments;
					}
				}
	
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final Renderer params; 
					public final Renderer fieldAssigments;
					
					private Params(Renderer params, Renderer fieldAssigments) {
						
						this.params = params;
						this.fieldAssigments = fieldAssigments;
					}
				
					static public final class Builder {
						
						private Renderer params; 
						private Renderer fieldAssigments;
						
						public Builder params(Renderer value) {
							
							this.params = value;
							return this;
						}
						
						public Builder fieldAssigments(Renderer value) {
							
							this.fieldAssigments = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(params, fieldAssigments);
						}
					}
				}
				
				static public abstract class Template_params extends ParameterizedTemplate<Template_params.Params> { 
					
					public final Parts parts;
					
					protected Template_params(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
						
						this.parts = new Parts(type, name, delimiter);
					}
					
					static public final class Parts {
						
						public final TextTemplate type;
						public final TextTemplate name; 
						public final TextTemplate delimiter;
						
						private Parts(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
							
							this.type = type;
							this.name = name;
							this.delimiter = delimiter;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String type;
						public final String name; 
						public final String delimiter;
						
						private Params(String type, String name, String delimiter) {
							
							this.type = type;
							this.name = name;
							this.delimiter = delimiter;
						}
					
						static public final class Builder {
							
							private String type;
							private String name; 
							private String delimiter;
							
							public Builder type(String value) {
								
								this.type = value;
								return this;
							}
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Builder delimiter(String value) {
								
								this.delimiter = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(type, name, delimiter);
							}
						}
					}
				}
				
				static public abstract class Template_fieldAssigments  extends ParameterizedTemplate<Template_fieldAssigments.Params> {
					
					public final Parts parts;
					
					protected Template_fieldAssigments(TextTemplate name) {
						
						this.parts = new Parts(name);
					}
					
					static public final class Parts {
						
						public final TextTemplate name;
						
						private Parts(TextTemplate value) {
							
							this.name = value;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String name; 
						
						private Params(String name) {
							
							this.name = name;
						}
					
						static public final class Builder {
							
							private String name; 
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(name);
							}
						}
					}
				}
			}
		}
		
		static public abstract class Template_paramsClass extends ParameterizedTemplate<Template_paramsClass.Params> {
			
			public final Parts parts;
			
			protected Template_paramsClass(Template_fields fields, Template_constructor constructor, Template_builderClass builderClass) {
				
				this.parts = new Parts(fields, constructor, builderClass);
			}
			
			static public final class Parts {
				
				public final Template_fields fields; 
				public final Template_constructor constructor;
				public final Template_builderClass builderClass;
				
				private Parts(Template_fields fields, Template_constructor constructor, Template_builderClass builderClass) {
					
					this.fields = fields;
					this.constructor = constructor;
					this.builderClass = builderClass;
				}
			}
	
			public Params.Builder params() {
	
				return new Params.Builder();
			}		
			
			static public final class Params {
			
				public final Renderer fields; 
				public final Renderer constructor;
				public final Renderer builderClass;
				
				private Params(Renderer fields, Renderer constructor, Renderer builderClass) {
					
					this.fields = fields;
					this.constructor = constructor;
					this.builderClass = builderClass;
				}
			
				static public final class Builder {
					
					private Renderer fields; 
					private Renderer constructor;
					private Renderer builderClass;
					
					public Params.Builder fields(Renderer value) {
						
						this.fields = value;
						return this;
					}
					
					public Params.Builder constructor(Renderer value) {
						
						this.constructor = value;
						return this;
					}
					
					public Params.Builder builderClass(Renderer value) {
						
						this.builderClass = value;
						return this;
					}
					
					public Params build() {
						
						return new Params(fields, constructor, builderClass);
					}
				}
			}
			
			static public abstract class Template_fields extends ParameterizedTemplate<Template_fields.Params> { 
				
				public final Parts parts;
				
				protected Template_fields(TextTemplate type, TextTemplate name) {
					
					this.parts = new Parts(type, name);
				}
				
				static public final class Parts {
					
					public final TextTemplate type;
					public final TextTemplate name; 
					
					private Parts(TextTemplate type, TextTemplate name) {
						
						this.type = type;
						this.name = name;
					}
				}
					
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final String type;
					public final String name; 
					
					private Params(String type, String name) {
						
						this.type = type;
						this.name = name;
					}
				
					static public final class Builder {
						
						private String type;
						private String name; 
						
						public Builder type(String value) {
							
							this.type = value;
							return this;
						}
						
						public Builder name(String value) {
							
							this.name = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(type, name);
						}
					}
				}
			}
			
			static public abstract class Template_constructor extends ParameterizedTemplate<Template_constructor.Params> {
				
				public final Template_constructor.Parts parts;
				
				protected Template_constructor(Template_params params, Template_fieldAssigments fieldAssigments) {
					
					this.parts = new Parts(params, fieldAssigments);
				}
				
				static public final class Parts {
					
					public final Template_params params; 
					public final Template_fieldAssigments fieldAssigments;
					
					private Parts(Template_params params, Template_fieldAssigments fieldAssigments) {
						
						this.params = params;
						this.fieldAssigments = fieldAssigments;
					}
				}
	
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final Renderer params; 
					public final Renderer fieldAssigments;
					
					private Params(Renderer params, Renderer fieldAssigments) {
						
						this.params = params;
						this.fieldAssigments = fieldAssigments;
					}
				
					static public final class Builder {
						
						private Renderer params; 
						private Renderer fieldAssigments;
						
						public Builder params(Renderer value) {
							
							this.params = value;
							return this;
						}
						
						public Builder fieldAssigments(Renderer value) {
							
							this.fieldAssigments = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(params, fieldAssigments);
						}
					}
				}
				
				static public abstract class Template_params extends ParameterizedTemplate<Template_params.Params> { 
					
					public final Parts parts;
					
					protected Template_params(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
						
						this.parts = new Parts(type, name, delimiter);
					}
					
					static public final class Parts {
						
						public final TextTemplate type;
						public final TextTemplate name; 
						public final TextTemplate delimiter;
						
						private Parts(TextTemplate type, TextTemplate name, TextTemplate delimiter) {
							
							this.type = type;
							this.name = name;
							this.delimiter = delimiter;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String type;
						public final String name; 
						public final String delimiter;
						
						private Params(String type, String name, String delimiter) {
							
							this.type = type;
							this.name = name;
							this.delimiter = delimiter;
						}
					
						static public final class Builder {
							
							private String type;
							private String name; 
							private String delimiter;
							
							public Builder type(String value) {
								
								this.type = value;
								return this;
							}
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Builder delimiter(String value) {
								
								this.delimiter = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(type, name, delimiter);
							}
						}
					}
				}
				
				static public abstract class Template_fieldAssigments  extends ParameterizedTemplate<Template_fieldAssigments.Params> {
					
					public final Parts parts;
					
					protected Template_fieldAssigments(TextTemplate name) {
						
						this.parts = new Parts(name);
					}
					
					static public final class Parts {
						
						public final TextTemplate name;
						
						private Parts(TextTemplate value) {
							
							this.name = value;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String name; 
						
						private Params(String name) {
							
							this.name = name;
						}
					
						static public final class Builder {
							
							private String name; 
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(name);
							}
						}
					}
				}
			}
		
			static public abstract class Template_builderClass extends ParameterizedTemplate<Template_builderClass.Params> {
				
				public final Parts parts;
				
				protected Template_builderClass(Template_fields fields, Template_builderMethods builderMethods, Template_buildMethod buildMethod) {
					
					this.parts = new Parts(fields, builderMethods, buildMethod);
				}
				
				static public final class Parts {
					
					public final Template_fields fields;
					public final Template_builderMethods builderMethods;
					public final Template_buildMethod buildMethod;
					
					private Parts(Template_fields fields, Template_builderMethods builderMethods, Template_buildMethod buildMethod) {
						
						this.fields = fields;
						this.builderMethods = builderMethods;
						this.buildMethod = buildMethod;
					}
				}
					
				public Params.Builder params() {
	
					return new Params.Builder();
				}		
				
				static public final class Params {
				
					public final Renderer fields;
					public final Renderer builderMethods;
					public final Renderer buildMethod;
					
					private Params(Renderer fields, Renderer builderMethods, Renderer buildMethod) {
						
						this.fields = fields;
						this.builderMethods = builderMethods;
						this.buildMethod = buildMethod;
					}
				
					static public final class Builder {
						
						private Renderer fields;
						private Renderer builderMethods;
						private Renderer buildMethod;
						
						public Builder fields(Renderer value) {
							
							this.fields = value;
							return this;
						}
						
						public Builder builderMethods(Renderer value) {
							
							this.builderMethods = value;
							return this;
						}
						
						public Builder buildMethod(Renderer value) {
							
							this.buildMethod = value;
							return this;
						}
						
						public Params build() {
							
							return new Params(fields, builderMethods, buildMethod);
						}
					}
				}
				
				static public abstract class Template_fields extends ParameterizedTemplate<Template_fields.Params> { 
					
					public final Parts parts;
					
					protected Template_fields(TextTemplate type, TextTemplate name) {
						
						this.parts = new Parts(type, name);
					}
					
					static public final class Parts {
						
						public final TextTemplate type;
						public final TextTemplate name; 
						
						private Parts(TextTemplate type, TextTemplate name) {
							
							this.type = type;
							this.name = name;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String type;
						public final String name; 
						
						private Params(String type, String name) {
							
							this.type = type;
							this.name = name;
						}
					
						static public final class Builder {
							
							private String type;
							private String name; 
							
							public Builder type(String value) {
								
								this.type = value;
								return this;
							}
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(type, name);
							}
						}
					}
				}
				
				static public abstract class Template_builderMethods extends ParameterizedTemplate<Template_builderMethods.Params> { 
					
					public final Parts parts;
					
					protected Template_builderMethods(TextTemplate name, TextTemplate type) {
						
						this.parts = new Parts(name, type);
					}
					
					static public final class Parts {
						
						public final TextTemplate name; 
						public final TextTemplate type;
						
						private Parts(TextTemplate name, TextTemplate type) {
							
							this.name = name;
							this.type = type;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final String name; 
						public final String type;
						
						private Params(String name, String type) {
							
							this.name = name;
							this.type = type;
						}
					
						static public final class Builder {
							
							private String name; 
							private String type;
							
							public Builder name(String value) {
								
								this.name = value;
								return this;
							}
							
							public Builder type(String value) {
								
								this.type = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(name, type);
							}
						}
					}
				}
			
				static public abstract class Template_buildMethod extends ParameterizedTemplate<Template_buildMethod.Params> {
				
					public final Parts parts;
					
					protected Template_buildMethod(Template_paramsConstructorArgs paramsConstructorArgs) {
						
						this.parts = new Parts(paramsConstructorArgs);
					}
					
					static public final class Parts {
						
						public final Template_paramsConstructorArgs paramsConstructorArgs;
						
						private Parts(Template_paramsConstructorArgs paramsConstructorArgs) {
							
							this.paramsConstructorArgs = paramsConstructorArgs;
						}
					}
						
					public Params.Builder params() {
	
						return new Params.Builder();
					}		
					
					static public final class Params {
					
						public final Renderer paramsConstructorArgs;
						
						private Params(Renderer paramsConstructorArgs) {
							
							this.paramsConstructorArgs = paramsConstructorArgs;
						}
					
						static public final class Builder {
							
							private Renderer paramsConstructorArgs;
							
							public Builder paramsConstructorArgs(Renderer value) {
								
								this.paramsConstructorArgs = value;
								return this;
							}
							
							public Params build() {
								
								return new Params(paramsConstructorArgs);
							}
						}
					}
					
					static public abstract class Template_paramsConstructorArgs  extends ParameterizedTemplate<Template_paramsConstructorArgs.Params> {
						
						public final Parts parts;
						
						protected Template_paramsConstructorArgs(TextTemplate value, TextTemplate delimiter) {
							
							this.parts = new Parts(value, delimiter);
						}
						
						static public final class Parts {
							
							public final TextTemplate value; 
							public final TextTemplate delimiter;
							
							private Parts(TextTemplate value, TextTemplate delimiter) {
								
								this.value = value;
								this.delimiter = delimiter;
							}
						}
							
						public Params.Builder params() {
	
							return new Params.Builder();
						}		
						
						static public final class Params {
						
							public final String value; 
							public final String delimiter;
							
							private Params(String value, String delimiter) {
								
								this.value = value;
								this.delimiter = delimiter;
							}
						
							static public final class Builder {
								
								private String value; 
								private String delimiter;
								
								public Builder value(String value) {
									
									this.value = value;
									return this;
								}
								
								public Builder delimiter(String value) {
									
									this.delimiter = value;
									return this;
								}
								
								public Params build() {
									
									return new Params(value, delimiter);
								}
							}
						}
					}
				}
			}
		}
		
		static public abstract class Template_partsClassesMembers extends ParameterizedTemplate<Template_partsClassesMembers.Params> {
		
			public final Parts parts;
			
			protected Template_partsClassesMembers(TextTemplate partClass) {
				
				this.parts = new Parts(partClass);
			}
			
			static public final class Parts {
				
				public final TextTemplate partClass;
				
				private Parts(TextTemplate partClass) {
					
					this.partClass = partClass;
				}
			}
				
			public Params.Builder params() {
	
				return new Params.Builder();
			}		
			
			static public final class Params {
			
				public final Renderer partClass;
				
				private Params(Renderer partClass) {
					
					this.partClass = partClass;
				}
			
				static public final class Builder {
					
					private Renderer partClass;
					
					public Builder partClass(Renderer value) {
						
						this.partClass = value;
						return this;
					}
					
					public Params build() {
						
						return new Params(partClass);
					}
				}
			}
		}
	}
}