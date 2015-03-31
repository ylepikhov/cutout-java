package cutout.java.util;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;

public final class TemplateImpl_templateClass extends Template_templateClass {

	static public final TemplateImpl_templateClass INSTANCE = new TemplateImpl_templateClass();
	
	private TemplateImpl_templateClass() {
		
		super(TextTemplate.EMPTY, TemplateImpl_partClass.INSTANCE);
		
	}
	
	static public final class TemplateRenderer extends Renderer {

		private final Params params;
		
		public TemplateRenderer(Params params) {

			this.params = params;
		}

		public void render(Appendable out) throws IOException {
			
			out.append("package ");
			out.append(params.packageName);
			out.append(";\r\n" + 
					"\r\n" + 
					"import cutout.java.ParameterizedTemplate;\r\n" +
					"import cutout.java.Renderer;\r\n" +
					"import cutout.java.TextTemplate;\r\n" +
					"\r\n" + 
					"");
			params.partClass.render(out);
		}
	}
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(params);
	}

	static public final class TemplateImpl_partClass extends Template_partClass {

		static public final TemplateImpl_partClass INSTANCE = new TemplateImpl_partClass();
		
		private TemplateImpl_partClass() {
			
			super(
				TextTemplate.EMPTY, 
				TemplateImpl_constructor.INSTANCE, 
				TemplateImpl_partsClass.INSTANCE, 
				TemplateImpl_paramsClass.INSTANCE, 
				TemplateImpl_partsClassesMembers.INSTANCE);

		}

		static public final class TemplateRenderer extends Renderer {
			
			private final Params params;
			
			private TemplateRenderer(Params params) {
				
				this.params = params;
			}
	
			public void render(Appendable out) throws IOException {
	
				out.append("\r\n" + 
						"public abstract class ");
				out.append(params.className);
				out.append(" extends ParameterizedTemplate<");
				out.append(params.className);
				out.append(".Params> {\r\n" + 
						"	\r\n" + 
						"	public final Parts parts;\r\n" + 
						"	\r\n" + 
						"	");
				params.constructor.render(out);
				out.append("\r\n" + 
						"	\r\n" + 
						"	");
				params.partsClass.render(out);
				out.append("\r\n" + 
						"		\r\n" + 
						"	static public Params.Builder params() {\r\n" + 
						"\r\n" + 
						"		return new Params.Builder();\r\n" + 
						"	}		\r\n" + 
						"	\r\n" + 
						"	");
				params.paramsClass.render(out);
				out.append("\r\n" + 
						"	\r\n" + 
						"	");
				params.partsClassesMembers.render(out);
				out.append("\r\n" + 
						"}\r\n" + 
						"");
			}
		}
		
		@Override
		public Renderer apply(Params params) {
			
			return new TemplateRenderer(params);
		}
		
		static public final class TemplateImpl_constructor extends Template_constructor {

			static public final TemplateImpl_constructor INSTANCE = new TemplateImpl_constructor();
			
			private TemplateImpl_constructor() {
				
				super(TextTemplate.EMPTY, TemplateImpl_params.INSTANCE, TemplateImpl_partsConstructorArgs.INSTANCE);
				
			}
			
			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {
					this.params = params;
				}

				public void render(Appendable out) throws IOException {

					out.append("\r\n" + 
							"	protected ");
					out.append(params.className);
					out.append("(");
					params.params.render(out);
					out.append(") {\r\n" + 
							"		\r\n" + 
							"		this.parts = new Parts(");
					params.partsConstructorArgs.render(out);
					out.append(");\r\n" + 
							"	}\r\n" + 
							"	");
				}
			}

			@Override
			public Renderer apply(Params params) {

				return new TemplateRenderer(params);
			}
			
			static public final class TemplateImpl_params extends Template_params {

				static public final TemplateImpl_params INSTANCE = new TemplateImpl_params();
				
				private TemplateImpl_params() {
					
					super(TextTemplate.EMPTY, TextTemplate.EMPTY, new TextTemplate(","));
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append(params.delimiter);
						out.append(params.type);
						out.append(" ");
						out.append(params.name);
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
			}
		
			static public final class TemplateImpl_partsConstructorArgs extends Template_partsConstructorArgs {

				static public final TemplateImpl_partsConstructorArgs INSTANCE = new TemplateImpl_partsConstructorArgs();
				
				private TemplateImpl_partsConstructorArgs() {
					
					super(TextTemplate.EMPTY, new TextTemplate(","));
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append(params.delimiter);
						out.append(params.value);
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
			}
		}
	
		static public final class TemplateImpl_partsClass extends Template_partsClass {

			static public final TemplateImpl_partsClass INSTANCE = new TemplateImpl_partsClass();
			
			private TemplateImpl_partsClass() {
				
				super(TemplateImpl_fields.INSTANCE, TemplateImpl_constructor.INSTANCE);
			}

			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {
					this.params = params;
				}

				public void render(Appendable out) throws IOException {
					
					out.append("\r\n" + 
							"	static public final class Parts {\r\n" + 
							"		\r\n" + 
							"		");
					params.fields.render(out);
					out.append("\r\n" + 
							"		\r\n" + 
							"		");
					params.constructor.render(out);
					out.append("\r\n" + 
							"	}\r\n" + 
							"	");
				}
			}
			
			@Override
			public Renderer apply(Params params) {
				
				return new TemplateRenderer(params);
			}
			
			static public final class TemplateImpl_fields extends Template_fields {

				static public final TemplateImpl_fields INSTANCE = new TemplateImpl_fields();
				
				private TemplateImpl_fields() {
					
					super(TextTemplate.EMPTY, TextTemplate.EMPTY);
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append("public final ");
						out.append(params.type);
						out.append(" ");
						out.append(params.name);
						out.append(";\r\n" + 
								"		");
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
			}
		
			static public final class TemplateImpl_constructor extends Template_constructor {
				
				static public final TemplateImpl_constructor INSTANCE = new TemplateImpl_constructor();
				
				private TemplateImpl_constructor() {
					
					super(TemplateImpl_params.INSTANCE, TemplateImpl_fieldAssigments.INSTANCE);
				}
				
				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append("\r\n" + 
								"		private Parts(");
						params.params.render(out);
						out.append(") {\r\n" + 
								"			\r\n" + 
								"			");
						params.fieldAssigments.render(out);
						out.append("\r\n" + 
								"		}\r\n" + 
								"		");
					}
				}

				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
				static public final class TemplateImpl_params extends Template_params {

					static public final TemplateImpl_params INSTANCE = new TemplateImpl_params();
					
					private TemplateImpl_params() {
						
						super(TextTemplate.EMPTY, TextTemplate.EMPTY, new TextTemplate(","));
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append(params.delimiter);
							out.append(params.type);
							out.append(" ");
							out.append(params.name);
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
				}
			
				static public final class TemplateImpl_fieldAssigments extends Template_fieldAssigments {

					static public final TemplateImpl_fieldAssigments INSTANCE = new TemplateImpl_fieldAssigments();
					
					private TemplateImpl_fieldAssigments() {
						
						super(TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append("this.");
							out.append(params.name);
							out.append(" = ");
							out.append(params.name);
							out.append(";");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
				}
			}
		}
	
		static public final class TemplateImpl_paramsClass extends Template_paramsClass {

			static public final TemplateImpl_paramsClass INSTANCE = new TemplateImpl_paramsClass();
			
			private TemplateImpl_paramsClass() {
				
				super(TemplateImpl_fields.INSTANCE, TemplateImpl_constructor.INSTANCE, TemplateImpl_builderClass.INSTANCE);

			}
			
			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {
					this.params = params;
				}

				public void render(Appendable out) throws IOException {

					out.append("\r\n" + 
							"	static public final class Params {\r\n" + 
							"	\r\n" + 
							"		");
					params.fields.render(out);
					out.append("\r\n" + 
							"		\r\n" + 
							"		");
					params.constructor.render(out);
					out.append("\r\n" + 
							"	\r\n" + 
							"		");
					params.builderClass.render(out);
					out.append("\r\n" + 
							"	}\r\n" + 
							"	");
				}
			}

			@Override
			public Renderer apply(Params params) {
				
				return new TemplateRenderer(params);
			}
			
			static public final class TemplateImpl_fields extends Template_fields {

				static public final TemplateImpl_fields INSTANCE = new TemplateImpl_fields();
				
				private TemplateImpl_fields() {
					
					super(TextTemplate.EMPTY, TextTemplate.EMPTY);
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append("public final ");
						out.append(params.type);
						out.append(" ");
						out.append(params.name);
						out.append(";\r\n" + 
								"		");
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
			}
		
			static public final class TemplateImpl_constructor extends Template_constructor {
				
				static public final TemplateImpl_constructor INSTANCE = new TemplateImpl_constructor();
				
				private TemplateImpl_constructor() {
					
					super(TemplateImpl_params.INSTANCE, TemplateImpl_fieldAssigments.INSTANCE);
				}
				
				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append("\r\n" + 
								"		private Params(");
						params.params.render(out);
						out.append(") {\r\n" + 
								"			\r\n" + 
								"			");
						params.fieldAssigments.render(out);
						out.append("\r\n" + 
								"		}\r\n" + 
								"		");
					}
				}

				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
				static public final class TemplateImpl_params extends Template_params {

					static public final TemplateImpl_params INSTANCE = new TemplateImpl_params();
					
					private TemplateImpl_params() {
						
						super(TextTemplate.EMPTY, TextTemplate.EMPTY, new TextTemplate(","));
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append(params.delimiter);
							out.append(params.type);
							out.append(" ");
							out.append(params.name);
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
				}
			
				static public final class TemplateImpl_fieldAssigments extends Template_fieldAssigments {

					static public final TemplateImpl_fieldAssigments INSTANCE = new TemplateImpl_fieldAssigments();
					
					private TemplateImpl_fieldAssigments() {
						
						super(TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append("this.");
							out.append(params.name);
							out.append(" = ");
							out.append(params.name);
							out.append(";");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
				}
			}
		
			static public final class TemplateImpl_builderClass extends Template_builderClass {

				static public final TemplateImpl_builderClass INSTANCE = new TemplateImpl_builderClass();
				
				private TemplateImpl_builderClass() {
					
					super(TemplateImpl_fields.INSTANCE, TemplateImpl_builderMethods.INSTANCE, TemplateImpl_buildMethod.INSTANCE);
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {
						this.params = params;
					}

					public void render(Appendable out) throws IOException {

						out.append("\r\n" + 
								"		static public final class Builder {\r\n" + 
								"			\r\n" + 
								"			");
						params.fields.render(out);
						out.append("\r\n" + 
								"			\r\n" + 
								"			");
						params.builderMethods.render(out);
						out.append("\r\n" + 
								"			\r\n" + 
								"			");
						params.buildMethod.render(out);
						out.append("\r\n" + 
								"		}\r\n" + 
								"		");
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
				static public final class TemplateImpl_fields extends Template_fields {

					static public final TemplateImpl_fields INSTANCE = new TemplateImpl_fields();
					
					private TemplateImpl_fields() {
						
						super(TextTemplate.EMPTY, TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append("private ");
							out.append(params.type);
							out.append(" ");
							out.append(params.name);
							out.append(";\r\n" + 
									"			");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
				}
			
				static public final class TemplateImpl_builderMethods extends Template_builderMethods {

					static public final TemplateImpl_builderMethods INSTANCE = new TemplateImpl_builderMethods();
					
					private TemplateImpl_builderMethods() {
						
						super(TextTemplate.EMPTY, TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {

							out.append("\r\n" + 
									"			public Builder ");
							out.append(params.name);
							out.append("(");
							out.append(params.type);
							out.append(" value) {\r\n" + 
									"				\r\n" + 
									"				this.");
							out.append(params.name);
							out.append(" = value;\r\n" + 
									"				return this;\r\n" + 
									"			}\r\n" + 
									"			");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
				}
			
				static public final class TemplateImpl_buildMethod extends Template_buildMethod {

					static public final TemplateImpl_buildMethod INSTANCE = new TemplateImpl_buildMethod();
					
					private TemplateImpl_buildMethod() {
						
						super(TemplateImpl_paramsConstructorArgs.INSTANCE);
					}
					
					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {
							this.params = params;
						}

						public void render(Appendable out) throws IOException {
							
							out.append("\r\n" + 
									"			public Params build() {\r\n" + 
									"				\r\n" + 
									"				return new Params(");
							params.paramsConstructorArgs.render(out);
							out.append(");\r\n" + 
									"			}\r\n" + 
									"			");
						}
					}

					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
					static public final class TemplateImpl_paramsConstructorArgs extends Template_paramsConstructorArgs {

						static public final TemplateImpl_paramsConstructorArgs INSTANCE = new TemplateImpl_paramsConstructorArgs();
						
						private TemplateImpl_paramsConstructorArgs() {
							
							super(TextTemplate.EMPTY, new TextTemplate(","));
						}

						static public final class TemplateRenderer extends Renderer {

							private final Params params;
							
							public TemplateRenderer(Params params) {
								this.params = params;
							}

							public void render(Appendable out) throws IOException {

								out.append(params.delimiter);
								out.append(params.value);
							}
						}
						
						@Override
						public Renderer apply(Params params) {

							return new TemplateRenderer(params);
						}
						
					}
				}
			}
		}
	
		static public final class TemplateImpl_partsClassesMembers extends Template_partsClassesMembers {

			static public final TemplateImpl_partsClassesMembers INSTANCE = new TemplateImpl_partsClassesMembers();
			
			private TemplateImpl_partsClassesMembers() {
				
				super(TextTemplate.EMPTY);
			}
			
			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {
					this.params = params;
				}

				public void render(Appendable out) throws IOException {

					out.append("static ");
					params.partClass.render(out);
				}	
			}

			@Override
			public Renderer apply(Params params) {
				
				return new TemplateRenderer(params);
			}
			
		}
	}
}