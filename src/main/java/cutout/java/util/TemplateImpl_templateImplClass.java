package cutout.java.util;

import cutout.java.Renderer;
import cutout.java.TextTemplate;

import java.io.IOException;

public class TemplateImpl_templateImplClass extends Template_templateImplClass {

	static public final Template_templateImplClass INSTANCE = new TemplateImpl_templateImplClass();
	
	private TemplateImpl_templateImplClass() {
		

		super(TextTemplate.EMPTY, TemplateImpl_implClass.INSTANCE);
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
					"import cutout.java.Renderer;\r\n" +
					"import cutout.java.TextTemplate;\r\n" +
					"\r\n" + 
					"import java.io.IOException;\r\n" + 
					"\r\n" + 
					"");
			params.implClass.render(out);
		}
	}
	
	@Override
	public Renderer apply(Params params) {

		return new TemplateRenderer(params);
	}

	static public final class TemplateImpl_implClass extends Template_implClass {

		static public final Template_implClass INSTANCE = new TemplateImpl_implClass();
		
		private TemplateImpl_implClass() {
			
			super(TextTemplate.EMPTY, TextTemplate.EMPTY, TemplateImpl_constructor.INSTANCE, TemplateImpl_rendererClass.INSTANCE, TemplateImpl_partsClassesMembers.INSTANCE);
		}

		static public final class TemplateRenderer extends Renderer {

			private final Params params;
			
			public TemplateRenderer(Params params) {

				this.params = params;
			}

			public void render(Appendable out) throws IOException {
				
				out.append("\r\n" + 
						"public final class ");
				out.append(params.className);
				out.append(" extends ");
				out.append(params.baseClassName);
				out.append(" {\r\n" + 
						"\r\n" + 
						"	static public final ");
				out.append(params.baseClassName);
				out.append(" INSTANCE = new ");
				out.append(params.className);
				out.append("();\r\n" + 
						"	\r\n" + 
						"	");
				params.constructor.render(out);
				out.append("\r\n" + 
						"	\r\n" + 
						"	");
				params.rendererClass.render(out);
				out.append("\r\n" + 
						"	\r\n" + 
						"	@Override\r\n" + 
						"	public Renderer apply(Params params) {\r\n" + 
						"\r\n" + 
						"		return new TemplateRenderer(params);\r\n" + 
						"	}\r\n" + 
						"\r\n" + 
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

			static public final Template_constructor INSTANCE = new TemplateImpl_constructor();
			
			private TemplateImpl_constructor() {
				
				super(TextTemplate.EMPTY, TemplateImpl_constructorArgs.INSTANCE);
			}

			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {

					this.params = params;
				}

				public void render(Appendable out) throws IOException {
					
					out.append("\r\n" + 
							"	private ");
					out.append(params.className);
					out.append("() {\r\n" + 
							"		\r\n" + 
							"		super(");
					params.constructorArgs.render(out);
					out.append(");\r\n" + 
							"		\r\n" + 
							"	}\r\n" + 
							"	");
				}
			}
			
			@Override
			public Renderer apply(Params params) {

				return new TemplateRenderer(params);
			}
			
			static public final class TemplateImpl_constructorArgs extends Template_constructorArgs {

				static public final Template_constructorArgs INSTANCE = new TemplateImpl_constructorArgs();
				
				private TemplateImpl_constructorArgs() {
					
					super(new TextTemplate(","), TemplateImpl_arg.INSTANCE);
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {

						this.params = params;
					}

					public void render(Appendable out) throws IOException {
						
						out.append(params.delimiter);
						params.arg.render(out);
						out.append("\r\n" + 
								"		");
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
				static public final class TemplateImpl_arg extends Template_arg {

					static public final Template_arg INSTANCE = new TemplateImpl_arg();
					
					private TemplateImpl_arg() {
						
						super(TemplateImpl_part.INSTANCE, new TextTemplate("TextTemplate.EMPTY"), TemplateImpl_value.INSTANCE);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {

							this.params = params;
						}

						public void render(Appendable out) throws IOException {
							
							out.append("\r\n" + 
									"			");
							params.part.render(out);
							params.empty.render(out);
							params.value.render(out);
							out.append("\r\n" + 
									"		");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
					
					static public final class TemplateImpl_part extends Template_part {

						static public final Template_part INSTANCE = new TemplateImpl_part();
						
						private TemplateImpl_part() {
							
							super(TextTemplate.EMPTY);
						}

						static public final class TemplateRenderer extends Renderer {

							private final Params params;
							
							public TemplateRenderer(Params params) {

								this.params = params;
							}

							public void render(Appendable out) throws IOException {
								
								out.append(params.className);
								out.append(".INSTANCE");
							}
						}
						
						@Override
						public Renderer apply(Params params) {

							return new TemplateRenderer(params);
						}
						
					}
					
					static public final class TemplateImpl_value extends Template_value {

						static public final Template_value INSTANCE = new TemplateImpl_value();
						
						private TemplateImpl_value() {
							
							super(TextTemplate.EMPTY);
						}

						static public final class TemplateRenderer extends Renderer {

							private final Params params;
							
							public TemplateRenderer(Params params) {

								this.params = params;
							}

							public void render(Appendable out) throws IOException {

								out.append("new TextTemplate(");
								out.append(params.stringValue);
								out.append(")");
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
	
		static public final class TemplateImpl_rendererClass extends Template_rendererClass {

			static public final Template_rendererClass INSTANCE = new TemplateImpl_rendererClass();
			
			private TemplateImpl_rendererClass() {
				
				super(TemplateImpl_renderStatements.INSTANCE);
			}

			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {

					this.params = params;
				}

				public void render(Appendable out) throws IOException {
					
					out.append("\r\n" + 
							"	static public final class TemplateRenderer extends Renderer {\r\n" + 
							"\r\n" + 
							"		private final Params params;\r\n" + 
							"		\r\n" + 
							"		public TemplateRenderer(Params params) {\r\n" + 
							"\r\n" + 
							"			this.params = params;\r\n" + 
							"		}\r\n" + 
							"\r\n" + 
							"		public void render(Appendable out) throws IOException {\r\n" + 
							"			\r\n" + 
							"			");
					params.renderStatements.render(out);
					out.append("\r\n" + 
							"		}\r\n" + 
							"	}\r\n" + 
							"	");
				}
			}
			
			@Override
			public Renderer apply(Params params) {

				return new TemplateRenderer(params);
			}
			
			static public final class TemplateImpl_renderStatements extends Template_renderStatements {

				static public final Template_renderStatements INSTANCE = new TemplateImpl_renderStatements();
				
				private TemplateImpl_renderStatements() {
					
					super(TemplateImpl_renderContent.INSTANCE, TemplateImpl_renderMark.INSTANCE, TemplateImpl_renderCut.INSTANCE);
				}

				static public final class TemplateRenderer extends Renderer {

					private final Params params;
					
					public TemplateRenderer(Params params) {

						this.params = params;
					}

					public void render(Appendable out) throws IOException {
						
						out.append("\r\n" + 
								"				");
						params.renderContent.render(out);
						params.renderMark.render(out);
						params.renderCut.render(out);
						out.append("\r\n" + 
								"			");
					}
				}
				
				@Override
				public Renderer apply(Params params) {

					return new TemplateRenderer(params);
				}
				
				static public final class TemplateImpl_renderContent extends Template_renderContent {

					static public final Template_renderContent INSTANCE = new TemplateImpl_renderContent();
					
					private TemplateImpl_renderContent() {
						
						super(TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {

							this.params = params;
						}

						public void render(Appendable out) throws IOException {
							
							out.append("out.append(");
							out.append(params.stringValue);
							out.append(");");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
				}
				
				static public final class TemplateImpl_renderMark extends Template_renderMark {

					static public final Template_renderMark INSTANCE = new TemplateImpl_renderMark();
					
					private TemplateImpl_renderMark() {
						
						super(TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {

							this.params = params;
						}

						public void render(Appendable out) throws IOException {
							
							out.append("out.append(params.");
							out.append(params.name);
							out.append(");");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
				}
				
				static public final class TemplateImpl_renderCut extends Template_renderCut {

					static public final Template_renderCut INSTANCE = new TemplateImpl_renderCut();
					
					private TemplateImpl_renderCut() {
						
						super(TextTemplate.EMPTY);
					}

					static public final class TemplateRenderer extends Renderer {

						private final Params params;
						
						public TemplateRenderer(Params params) {

							this.params = params;
						}

						public void render(Appendable out) throws IOException {
							
							out.append("params.");
							out.append(params.name);
							out.append(".render(out);");
						}
					}
					
					@Override
					public Renderer apply(Params params) {

						return new TemplateRenderer(params);
					}
				}
			}
		}
	
		static public final class TemplateImpl_partsClassesMembers extends Template_partsClassesMembers {

			static public final Template_partsClassesMembers INSTANCE = new TemplateImpl_partsClassesMembers();
			
			private TemplateImpl_partsClassesMembers() {
				
				super(TextTemplate.EMPTY);
			}

			static public final class TemplateRenderer extends Renderer {

				private final Params params;
				
				public TemplateRenderer(Params params) {

					this.params = params;
				}

				public void render(Appendable out) throws IOException {
					
					out.append("\r\n" + 
							"	static ");
					params.partClass.render(out);
					out.append("\r\n" + 
							"	");
				}
			}
			
			@Override
			public Renderer apply(Params params) {

				return new TemplateRenderer(params);
			}
		}
	}
}