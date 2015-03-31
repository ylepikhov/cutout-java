package cutout.java.util;

import cutout.java.ParameterizedTemplate;
import cutout.java.Renderer;
import cutout.java.TextTemplate;

public abstract class Template_templateImplClass extends
        ParameterizedTemplate<Template_templateImplClass.Params> {

	public final Parts parts;

	protected Template_templateImplClass(TextTemplate packageName,
			Template_implClass implClass) {

		this.parts = new Parts(packageName, implClass);
	}

	static public final class Parts {

		public final TextTemplate packageName;
		public final Template_implClass implClass;

		private Parts(TextTemplate packageName, Template_implClass implClass) {

			this.packageName = packageName;
			this.implClass = implClass;
		}

	}

	public Params.Builder params() {

		return new Params.Builder();
	}

	static public final class Params {

		public final String packageName;
		public final Renderer implClass;

		private Params(String packageName, Renderer implClass) {

			this.packageName = packageName;
			this.implClass = implClass;
		}

		static public final class Builder {

			private String packageName;
			private Renderer implClass;

			public Builder packageName(String value) {

				this.packageName = value;
				return this;
			}

			public Builder implClass(Renderer value) {

				this.implClass = value;
				return this;
			}

			public Params build() {

				return new Params(packageName, implClass);
			}

		}

	}

	static public abstract class Template_implClass extends
			ParameterizedTemplate<Template_implClass.Params> {

		public final Parts parts;

		protected Template_implClass(TextTemplate className,
				TextTemplate baseClassName, Template_constructor constructor,
				Template_rendererClass rendererClass,
				Template_partsClassesMembers partsClassesMembers) {

			this.parts = new Parts(className, baseClassName, constructor,
					rendererClass, partsClassesMembers);
		}

		static public final class Parts {

			public final TextTemplate className;
			public final TextTemplate baseClassName;
			public final Template_constructor constructor;
			public final Template_rendererClass rendererClass;
			public final Template_partsClassesMembers partsClassesMembers;

			private Parts(TextTemplate className, TextTemplate baseClassName,
					Template_constructor constructor,
					Template_rendererClass rendererClass,
					Template_partsClassesMembers partsClassesMembers) {

				this.className = className;
				this.baseClassName = baseClassName;
				this.constructor = constructor;
				this.rendererClass = rendererClass;
				this.partsClassesMembers = partsClassesMembers;
			}

		}

		public Params.Builder params() {

			return new Params.Builder();
		}

		static public final class Params {

			public final String className;
			public final String baseClassName;
			public final Renderer constructor;
			public final Renderer rendererClass;
			public final Renderer partsClassesMembers;

			private Params(String className, String baseClassName,
					Renderer constructor, Renderer rendererClass,
					Renderer partsClassesMembers) {

				this.className = className;
				this.baseClassName = baseClassName;
				this.constructor = constructor;
				this.rendererClass = rendererClass;
				this.partsClassesMembers = partsClassesMembers;
			}

			static public final class Builder {

				private String className;
				private String baseClassName;
				private Renderer constructor;
				private Renderer rendererClass;
				private Renderer partsClassesMembers;

				public Builder className(String value) {

					this.className = value;
					return this;
				}

				public Builder baseClassName(String value) {

					this.baseClassName = value;
					return this;
				}

				public Builder constructor(Renderer value) {

					this.constructor = value;
					return this;
				}

				public Builder rendererClass(Renderer value) {

					this.rendererClass = value;
					return this;
				}

				public Builder partsClassesMembers(Renderer value) {

					this.partsClassesMembers = value;
					return this;
				}

				public Params build() {

					return new Params(className, baseClassName, constructor,
							rendererClass, partsClassesMembers);
				}

			}

		}

		static public abstract class Template_constructor extends
				ParameterizedTemplate<Template_constructor.Params> {

			public final Parts parts;

			protected Template_constructor(TextTemplate className,
					Template_constructorArgs constructorArgs) {

				this.parts = new Parts(className, constructorArgs);
			}

			static public final class Parts {

				public final TextTemplate className;
				public final Template_constructorArgs constructorArgs;

				private Parts(TextTemplate className,
						Template_constructorArgs constructorArgs) {

					this.className = className;
					this.constructorArgs = constructorArgs;
				}

			}

			public Params.Builder params() {

				return new Params.Builder();
			}

			static public final class Params {

				public final String className;
				public final Renderer constructorArgs;

				private Params(String className, Renderer constructorArgs) {

					this.className = className;
					this.constructorArgs = constructorArgs;
				}

				static public final class Builder {

					private String className;
					private Renderer constructorArgs;

					public Builder className(String value) {

						this.className = value;
						return this;
					}

					public Builder constructorArgs(Renderer value) {

						this.constructorArgs = value;
						return this;
					}

					public Params build() {

						return new Params(className, constructorArgs);
					}

				}

			}

			static public abstract class Template_constructorArgs extends
					ParameterizedTemplate<Template_constructorArgs.Params> {

				public final Parts parts;

				protected Template_constructorArgs(TextTemplate delimiter,
						Template_arg arg) {

					this.parts = new Parts(delimiter, arg);
				}

				static public final class Parts {

					public final TextTemplate delimiter;
					public final Template_arg arg;

					private Parts(TextTemplate delimiter, Template_arg arg) {

						this.delimiter = delimiter;
						this.arg = arg;
					}

				}

				public Params.Builder params() {

					return new Params.Builder();
				}

				static public final class Params {

					public final String delimiter;
					public final Renderer arg;

					private Params(String delimiter, Renderer arg) {

						this.delimiter = delimiter;
						this.arg = arg;
					}

					static public final class Builder {

						private String delimiter;
						private Renderer arg;

						public Builder delimiter(String value) {

							this.delimiter = value;
							return this;
						}

						public Builder arg(Renderer value) {

							this.arg = value;
							return this;
						}

						public Params build() {

							return new Params(delimiter, arg);
						}

					}

				}

				static public abstract class Template_arg extends
						ParameterizedTemplate<Template_arg.Params> {

					public final Parts parts;

					protected Template_arg(Template_part part,
							TextTemplate empty, Template_value value) {

						this.parts = new Parts(part, empty, value);
					}

					static public final class Parts {

						public final Template_part part;
						public final TextTemplate empty;
						public final Template_value value;

						private Parts(Template_part part, TextTemplate empty,
								Template_value value) {

							this.part = part;
							this.empty = empty;
							this.value = value;
						}

					}

					public Params.Builder params() {

						return new Params.Builder();
					}

					static public final class Params {

						public final Renderer part;
						public final Renderer empty;
						public final Renderer value;

						private Params(Renderer part, Renderer empty,
								Renderer value) {

							this.part = part;
							this.empty = empty;
							this.value = value;
						}

						static public final class Builder {

							private Renderer part;
							private Renderer empty;
							private Renderer value;

							public Builder part(Renderer value) {

								this.part = value;
								return this;
							}

							public Builder empty(Renderer value) {

								this.empty = value;
								return this;
							}

							public Builder value(Renderer value) {

								this.value = value;
								return this;
							}

							public Params build() {

								return new Params(part, empty, value);
							}

						}

					}

					static public abstract class Template_part extends
							ParameterizedTemplate<Template_part.Params> {

						public final Parts parts;

						protected Template_part(TextTemplate className) {

							this.parts = new Parts(className);
						}

						static public final class Parts {

							public final TextTemplate className;

							private Parts(TextTemplate className) {

								this.className = className;
							}

						}

						public Params.Builder params() {

							return new Params.Builder();
						}

						static public final class Params {

							public final String className;

							private Params(String className) {

								this.className = className;
							}

							static public final class Builder {

								private String className;

								public Builder className(String value) {

									this.className = value;
									return this;
								}

								public Params build() {

									return new Params(className);
								}

							}

						}

					}

					static public abstract class Template_value extends
							ParameterizedTemplate<Template_value.Params> {

						public final Parts parts;

						protected Template_value(TextTemplate stringValue) {

							this.parts = new Parts(stringValue);
						}

						static public final class Parts {

							public final TextTemplate stringValue;

							private Parts(TextTemplate stringValue) {

								this.stringValue = stringValue;
							}

						}

						public Params.Builder params() {

							return new Params.Builder();
						}

						static public final class Params {

							public final String stringValue;

							private Params(String stringValue) {

								this.stringValue = stringValue;
							}

							static public final class Builder {

								private String stringValue;

								public Builder stringValue(String value) {

									this.stringValue = value;
									return this;
								}

								public Params build() {

									return new Params(stringValue);
								}

							}

						}

					}

				}

			}

		}

		static public abstract class Template_rendererClass extends
				ParameterizedTemplate<Template_rendererClass.Params> {

			public final Parts parts;

			protected Template_rendererClass(
					Template_renderStatements renderStatements) {

				this.parts = new Parts(renderStatements);
			}

			static public final class Parts {

				public final Template_renderStatements renderStatements;

				private Parts(Template_renderStatements renderStatements) {

					this.renderStatements = renderStatements;
				}

			}

			public Params.Builder params() {

				return new Params.Builder();
			}

			static public final class Params {

				public final Renderer renderStatements;

				private Params(Renderer renderStatements) {

					this.renderStatements = renderStatements;
				}

				static public final class Builder {

					private Renderer renderStatements;

					public Builder renderStatements(Renderer value) {

						this.renderStatements = value;
						return this;
					}

					public Params build() {

						return new Params(renderStatements);
					}

				}

			}

			static public abstract class Template_renderStatements extends
					ParameterizedTemplate<Template_renderStatements.Params> {

				public final Parts parts;

				protected Template_renderStatements(
						Template_renderContent renderContent,
						Template_renderMark renderMark,
						Template_renderCut renderCut) {

					this.parts = new Parts(renderContent, renderMark, renderCut);
				}

				static public final class Parts {

					public final Template_renderContent renderContent;
					public final Template_renderMark renderMark;
					public final Template_renderCut renderCut;

					private Parts(Template_renderContent renderContent,
							Template_renderMark renderMark,
							Template_renderCut renderCut) {

						this.renderContent = renderContent;
						this.renderMark = renderMark;
						this.renderCut = renderCut;
					}

				}

				public Params.Builder params() {

					return new Params.Builder();
				}

				static public final class Params {

					public final Renderer renderContent;
					public final Renderer renderMark;
					public final Renderer renderCut;

					private Params(Renderer renderContent, Renderer renderMark,
							Renderer renderCut) {

						this.renderContent = renderContent;
						this.renderMark = renderMark;
						this.renderCut = renderCut;
					}

					static public final class Builder {

						private Renderer renderContent;
						private Renderer renderMark;
						private Renderer renderCut;

						public Builder renderContent(Renderer value) {

							this.renderContent = value;
							return this;
						}

						public Builder renderMark(Renderer value) {

							this.renderMark = value;
							return this;
						}

						public Builder renderCut(Renderer value) {

							this.renderCut = value;
							return this;
						}

						public Params build() {

							return new Params(renderContent, renderMark,
									renderCut);
						}

					}

				}

				static public abstract class Template_renderContent extends
						ParameterizedTemplate<Template_renderContent.Params> {

					public final Parts parts;

					protected Template_renderContent(TextTemplate stringValue) {

						this.parts = new Parts(stringValue);
					}

					static public final class Parts {

						public final TextTemplate stringValue;

						private Parts(TextTemplate stringValue) {

							this.stringValue = stringValue;
						}

					}

					public Params.Builder params() {

						return new Params.Builder();
					}

					static public final class Params {

						public final String stringValue;

						private Params(String stringValue) {

							this.stringValue = stringValue;
						}

						static public final class Builder {

							private String stringValue;

							public Builder stringValue(String value) {

								this.stringValue = value;
								return this;
							}

							public Params build() {

								return new Params(stringValue);
							}

						}

					}

				}

				static public abstract class Template_renderMark extends
						ParameterizedTemplate<Template_renderMark.Params> {

					public final Parts parts;

					protected Template_renderMark(TextTemplate name) {

						this.parts = new Parts(name);
					}

					static public final class Parts {

						public final TextTemplate name;

						private Parts(TextTemplate name) {

							this.name = name;
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

				static public abstract class Template_renderCut extends
						ParameterizedTemplate<Template_renderCut.Params> {

					public final Parts parts;

					protected Template_renderCut(TextTemplate name) {

						this.parts = new Parts(name);
					}

					static public final class Parts {

						public final TextTemplate name;

						private Parts(TextTemplate name) {

							this.name = name;
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

		static public abstract class Template_partsClassesMembers extends
				ParameterizedTemplate<Template_partsClassesMembers.Params> {

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
