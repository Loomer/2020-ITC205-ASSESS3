# 2020-ITC205-ASSESS3
Assessment item 3 - Dynamic Testing

<h4>Assessment item 3 - Dynamic Testing</h4>
						</div>
						<div class="pdf-hide">
							<p><a class="anchor-link" href="#contentPanel">back to top</a></p>
						</div>
					</div>

					<div>
						<strong>Value:</strong>
						
						<span>
							<span>40</span>%
						</span>
					</div>
					<div>
						<strong>Due Date:</strong>
						
						<span>25-Sep-2020</span>
						
						<!-- show the centrally administered content if applicable -->
						
					</div>
					<div>
						<strong>Return Date:</strong>
						
						<span>20-Oct-2020</span>
						
					</div>
					
					
					<div>
						
						<div>
							<strong>Submission method options:</strong>
							<span>
								<span>
									<span>EASTS (online)</span>
									
									
									
								</span>
							</span>
							
						</div>
						
					</div>

					<!-- iterate over each assessment item child section -->
					<section id="section-6-2-3-1">

						<div class="level-4">

			<!-- display heading as a header -->
			<div class="sectionHeader section-header">
				<div class="sectionHeaderTitle section-header-title">
					<header>
						
						
						<h5>Task</h5>
					</header>
					
				</div>
				<div class="pdf-hide">
					<a class="anchor-link" href="#contentPanel">back to top</a>
				</div>
			</div>

			<!-- display heading inline -->
			

			<!-- display learning outcomes -->
			

			<!-- display section value, if the section type is not a banner  -->
			
			<div class="fr-view section-value"><div class="word-content"><p style="margin:0in;margin-bottom:.0001pt;">Assignment 3 walks you through the full range of developer based dynamic software testing.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">In
 Part A, you need to critically analyse the provided case study and 
design documents to determine the areas of highest product and technical
 risk. You then need to create a minimal ‘Master Test Plan’ in which you
 specify the amounts and types of testing you will apply to different 
aspects of the application. &nbsp;</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">In
 Part B, you are required to implement a full range of dynamic tests for
 a particular use case, ranging from low level unit tests, through at 
least two levels of integration testing, to system testing.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Part C asks you to engage in some critical reflection on the effectiveness and utility of different aspects of dynamic testing.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Please
 note that it is recognised that standard practice is to specify user 
acceptance tests before development activities occur, and to conduct 
unit testing as classes are initially coded. Unfortunately, the semester
 timetable makes this impractical.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Also
 note that the focus in this assignment is on the process and techniques
 applied, not the complexity of the code. It is recognised that the 
process applied is ‘way over the top’ for the size of problem addressed.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Finally,
 please note that the code supplied is deliberately NOT bug free. The 
purpose of your testing is to expose those bugs. You are specifically 
instructed NOT to modify the code to eliminate those bugs. You are ONLY 
to implement and report on the results of your testing.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Tasks&nbsp;</strong></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Part A – Master Test Plan (10 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;">You
 are provided with a case study and a set of design documents and 
diagrams which support a use case. You are required to analyse the 
product and technical risks implied by these artefacts and develop a 
minimal ‘Master Test Plan’ which addresses these risks.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Quality criteria for a minimal master test plan include:</p><ol><li>Provides an overview of the project objectives&nbsp;</li><li>Identifies testing objectives in terms of problem domain outcomes</li><li>Identifies areas of product and technical risk</li><li>Identifies
 a test strategy for each risk (test level at which risk is addressed, 
extent and coverage of testing, including static testing approaches)</li><li>For each test level, identifies the test approach (test environment, test goals, entry criteria, exit criteria, defect response)</li></ol><p style="margin:0in;margin-bottom:.0001pt;"><strong>Part B – Dynamic Testing (80 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;">You
 are provided with an implementation and a ‘master test plan’ which 
specifies the areas of concern, types of testing and coverage required 
for the application. You are required to implement a suite of dynamic 
tests to enact that plan using best practice testing techniques and 
procedures.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Unit Testing - 30 marks</strong></p><p style="margin:0in;margin-bottom:.0001pt;">Implement a suite of unit tests according to the master test plan using best practice unit test techniques and processes.&nbsp;</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">These include:</p><ol><li>Tests are well organised and well named</li><li>Tests are well structured (Arrange, act, assert internal structure)</li><li>Tests are isolated (Tests only one code unit)</li><li>Tests are independent (Can be run in any order, don’t depend on external services or state)</li><li>Tests for error conditions included</li><li>Tests achieve appropriate level of coverage (as specified in the master test plan)</li><li>Each test tests only one thing (No logic in test, in general one assert per test)&nbsp;</li><li>Tests are automated (Do not require visual inspection to differentiate passing or failing)</li><li>Makes effective use of a test framework and test substitute library as appropriate (such as Junit, and Mockito)</li><li>Tests separated from production code</li></ol><p style="margin:0in;margin-bottom:.0001pt;"><strong>Integration Testing - 30 marks</strong></p><p style="margin:0in;margin-bottom:.0001pt;">Implement
 a suite of integration tests according to the master test plan using 
best practice integration test techniques and processes.&nbsp;</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Use
 a ‘bottom up’ or ‘top down’ approach to check interaction between 
entities and between control and entity classes. Using your ‘master test
 plan’ as a guide, make sure you test the most critical and/or risky 
system operation. &nbsp;You are not required to test boundary (user 
interaction) classes.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Guidelines for best practice integration testing include:&nbsp;</p><ol><li>Tests are well organised and well named</li><li>Tests are well structured (Arrange, act, assert internal structure)</li><li>Tests are isolated to only those code units included in the intended level of integration.&nbsp;</li><li>Tests are independent (Can be run in any order, don’t depend on external services or state)</li><li>Tests for error conditions included</li><li>Tests achieve appropriate level of coverage (as specified in the master test plan)</li><li>Each test tests only one thing (no logic in test, in general one assert per test)&nbsp;</li><li>Tests separated from production code</li><li>All levels of integration are addressed&nbsp;</li><li>Tests are automated (Do not require visual inspection to differentiate passing or failing)</li><li>Makes effective use of a test framework and test substitute library as appropriate (such as Junit, and Mockito)</li></ol><p style="margin:0in;margin-bottom:.0001pt;"><strong>System Tests - 20 marks</strong></p><p style="margin:0in;margin-bottom:.0001pt;">On
 the basis of the requirement and design documentation identify some 
system test cases which can be used to check correct functionality in 
the implemented use case. Specify system test procedures, test data, and
 expected results. A template for a system test will be available in the
 Resources section of the subject's Interact site.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Carry
 out the system tests you specified. Use the test data and procedures 
specified and check that it meets stated acceptance criteria. Report on 
the success or otherwise of the test. Include screenshots as evidence of
 your results in your test reports.</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">System test quality criteria include:</p><ol><li>Tests are well organised (test cases are organised into test scenarios addressing specific functional areas.</li><li>Test are well named</li><li>Preconditions are completely and concretely specified.</li><li>Test data are completely and concretely specified</li><li>Postconditions are completely and concretely specified</li><li>Test steps and expected results for each step are completely and concretely specified</li><li>Tests are objectively evaluated and supporting evidence for test results is provided</li></ol><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Part C –&nbsp;</strong><strong style="font-size: 16px; background-color: initial;">Reflective Practice (10 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;">Write a reflective report in which you critically evaluate the following questions:</p><ol style="margin-bottom:0in;" type="1" start="1"><li style="margin:0in;margin-bottom:.0001pt;">Which
 aspect of testing was the most effective? i.e. Which aspect of testing 
discovered the most defects for the effort expended?</li><li style="margin:0in;margin-bottom:.0001pt;">How relevant and useful are the guidelines for good unit testing practices?</li><li style="margin:0in;margin-bottom:.0001pt;">How easy is it to achieve comprehensive test coverage? What proportion of programming effort should be allocated to testing?</li><li style="margin:0in;margin-bottom:.0001pt;">How effective is dynamic testing compared to static code review in terms of discovering defects?</li></ol></div><!-- end word-conent --></div>

			<!-- display graduate learning outcomes -->
			

			<!-- display assessment items if this section contains them -->
			

			<!-- iterate over each child section -->
			

		</div>
					</section>
					<section id="section-6-2-3-2">

						<div class="level-4">

			<!-- display heading as a header -->
			<div class="sectionHeader section-header">
				<div class="sectionHeaderTitle section-header-title">
					<header>
						
						
						<h5>Rationale</h5>
					</header>
					
				</div>
				<div class="pdf-hide">
					<a class="anchor-link" href="#contentPanel">back to top</a>
				</div>
			</div>

			<!-- display heading inline -->
			

			<!-- display learning outcomes -->
			<div class="learning-outcomes">
				<h6 class="learning-outcomes-header">Subject learning outcomes</h6>

				<!-- display learning outcome stem text -->
				<div>
					<p class="learning-outcomes-stem-paragraph">This assessment task will assess the following learning outcome/s:</p>
					
					
				</div>
				

				<!-- display the list of learning outcomes -->
				<ul>
					<li>
						<span>be able to recognise and apply knowledge and skills to 
effectively utilize version control as part of professional programming 
practice.</span>
					</li>
					<li>
						<span>be able to identify the purpose and limitations of software testing.</span>
					</li>
					<li>
						<span>be able to design and implement an appropriate suite of software tests to support the complete system development life cycle.</span>
					</li>
				</ul>
			</div>

			<!-- display section value, if the section type is not a banner  -->
			
			<div class="fr-view section-value"><p>The intent of the assignment is
 to articulate taught concepts and skills in the context of developing a
 suite of unit, integration, and user acceptance tests for a small 
application.</p></div>

			<!-- display graduate learning outcomes -->
			<div class="learning-outcomes">
				<div>
					<h6 class="learning-outcomes-header">Graduate learning outcomes</h6>
					<p class="learning-outcomes-stem-paragraph">
						This task also contributes to the assessment of the following <a href="https://student.csu.edu.au/study/glo" target="_blank">CSU Graduate Learning Outcome/s</a>:
					</p>
					<ul>
						<li>
							<span>Professional Practice (Skill) - CSU Graduates demonstrate 
discipline-specific technical capabilities and self-appraisal required 
for a beginning practitioner or professional.</span>
						</li>
					</ul>
				</div>
			</div>

			<!-- display assessment items if this section contains them -->
			

			<!-- iterate over each child section -->
			

		</div>
					</section>
					<section id="section-6-2-3-3" class=" landscape">

						<div class="level-4">

			<!-- display heading as a header -->
			<div class="sectionHeader section-header">
				<div class="sectionHeaderTitle section-header-title">
					<header>
						
						
						<h5>Marking criteria and standards</h5>
					</header>
					
				</div>
				<div class="pdf-hide">
					<a class="anchor-link" href="#contentPanel">back to top</a>
				</div>
			</div>

			<!-- display heading inline -->
			

			<!-- display learning outcomes -->
			

			<!-- display section value, if the section type is not a banner  -->
			
			<div class="fr-view section-value"><div class="word-content"><p style="margin:0in;margin-bottom:.0001pt;"><strong>Master Test Plan (10 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Quality criteria:</p><ol><li>Provides an overview of the project objectives&nbsp;</li><li>Identifies test objectives in terms of problem domain outcomes</li><li>Identifies areas of product and technical risk</li><li>Identifies
 a test strategy for each risk (test level at which risk is addressed, 
extent and coverage of testing, including static testing approaches))</li><li>For
 each test level, identifies the test approach (test environment, test 
goals, entry criteria, exit criteria, defect response)&nbsp;</li></ol><table cellspacing="0" cellpadding="0" border="1"><tbody><tr><td rowspan="2" style="vertical-align: middle; width: 20.1546%; text-align: center;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;"><strong>Master Test Plan</strong></p></td><td style="vertical-align: top; width: 18.9652%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">HD</p></td><td style="vertical-align: top; width: 22.1437%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">DI</p></td><td style="vertical-align: top; width: 20.2692%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">CR</p></td><td style="vertical-align: top; width: 19.1279%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">PS</p></td></tr><tr><td style="vertical-align: top; width: 18.9652%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">8.5 – 10.0</p></td><td style="vertical-align: top; width: 22.1437%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">7.5 – 8.4</p></td><td style="vertical-align: top; width: 20.2692%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">6.5 – 7.4</p></td><td style="vertical-align: top; width: 19.1279%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">5.0 – 6.4</p></td></tr><tr><td style="vertical-align: top; width: 20.1546%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">How
 well did the student demonstrate understanding and skills relating to 
software testing in the context of specifying a master test plan?</p></td><td style="vertical-align: top; width: 18.9652%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">All criteria completely satisfied.</p></td><td style="vertical-align: top; width: 22.1437%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely achieved criteria 1, 2, and 3</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Achieved criteria 4 and 5 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p></td><td style="vertical-align: top; width: 20.2692%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely achieved criteria 1</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Achieved criteria 2 and 3 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Achieved criteria 4 and 5 to a partial extent</p></td><td style="vertical-align: top; width: 19.1279%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Achieved criteria 1 and 2 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Achieved criteria 3, 4, and 5 to a partial extent</p></td></tr></tbody></table><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Unit Testing (20 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Quality criteria:</p><ol><li>Tests are well organised and well named</li><li>Tests are well structured (Arrange, act, assert internal structure)</li><li>Tests are isolated (Tests only one code unit)</li><li>Tests are independent (Can be run in any order, don’t depend on external services or state)</li><li>Tests for error conditions included</li><li>Tests achieve appropriate level of coverage (as specified in the master test plan)</li><li>Each test tests only one thing (no logic in test, in general one assert per test)&nbsp;</li><li>Tests are automated (Do not require visual inspection to differentiate passing or failing)</li><li>Makes effective use of a test framework and test substitute library as appropriate (such as Junit, and Mockito)</li><li>Tests separated from production code&nbsp;</li></ol><table cellspacing="0" cellpadding="0" border="1"><tbody><tr><td rowspan="2" style="vertical-align: middle;" width="20%" valign="top"><p style="margin: 0in 0in 0.0001pt; text-align: center;"><strong>Unit Testing</strong></p></td><td style="vertical-align: top; width: 19.2581%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">HD</p></td><td style="vertical-align: top; width: 21.3771%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">DI</p></td><td style="vertical-align: top; width: 21.5403%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">CR</p></td><td style="vertical-align: top; width: 17.9055%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">PS</p></td></tr><tr><td style="vertical-align: top; width: 19.2581%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">17.0 – 20.0</p></td><td style="vertical-align: top; width: 21.3771%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">15.0 – 16.9</p></td><td style="vertical-align: top; width: 21.5403%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">13.0 – 14.9</p></td><td style="vertical-align: top; width: 17.9055%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">10.0 – 12.9</p></td></tr><tr><td style="vertical-align: top;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">How
 well did the student demonstrate understanding and skills relating to 
software testing in the context of implementing a set of unit tests?</p></td><td style="vertical-align: top; width: 19.2581%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">All criteria completely satisfied.</p></td><td style="vertical-align: top; width: 21.3771%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely satisfied criteria 1, 2, 3, 4, and 5</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 6, 7, 8, 9, and 10 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p></td><td style="vertical-align: top; width: 21.5403%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely satisfied criteria 1, 2, 3, and 4</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 5, 6, and 7 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 8 and 9 to a partial extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">May not have satisfied criteria</p><p style="margin:0in;margin-bottom:.0001pt;">10</p></td><td style="vertical-align: top; width: 17.9055%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 1, 2, 3, and 4 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 5, 6, and 7 to a partial extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">May not have satisfied criteria 8, 9, and 10&nbsp;</p></td></tr></tbody></table><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>Integration Testing (20 marks)</strong></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Quality criteria:</p><ol><li>Tests are well organised and well named</li><li>Tests are well structured (Arrange, act, assert internal structure)</li><li>Tests are isolated to only those code units included in the intended level of integration.&nbsp;</li><li>Tests are independent (Can be run in any order, don’t depend on external services or state)</li><li>Tests for error conditions included</li><li>All levels of integration are addressed&nbsp;</li><li>Tests achieve appropriate level of coverage (as specified in the master test plan)</li><li>Each test tests only one thing (no logic in test, in general one assert per test)&nbsp;</li><li>Tests are automated (Do not require visual inspection to differentiate passing or failing)</li><li>Makes effective use of a test framework and test substitute library as appropriate (such as Junit, and Mockito)</li><li>Tests separated from production code</li></ol><table cellspacing="0" cellpadding="0" border="1"><tbody><tr><td rowspan="2" style="vertical-align: middle; width: 20.6436%;" width="20%" valign="top"><p style="margin: 0in 0in 0.0001pt; text-align: center;"><strong>Integration Testing</strong></p></td><td style="vertical-align: top; width: 19.8286%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">HD</p></td><td style="vertical-align: top; width: 20.0247%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">DI</p></td><td style="vertical-align: top; width: 20.5137%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">CR</p></td><td style="vertical-align: top; width: 19.2095%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">PS</p></td></tr><tr><td style="vertical-align: top; width: 19.8286%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">17.0 – 20.0</p></td><td style="vertical-align: top; width: 20.0247%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">15.0 – 16.9</p></td><td style="vertical-align: top; width: 20.5137%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">13.0 – 14.9</p></td><td style="vertical-align: top; width: 19.2095%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">10.0 – 12.9</p></td></tr><tr><td style="vertical-align: top; width: 20.6436%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">How
 well did the student demonstrate understanding and skills relating to 
software testing in the context of implementing a set of integration 
tests?</p></td><td style="vertical-align: top; width: 19.8286%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">All criteria completely satisfied.</p></td><td style="vertical-align: top; width: 20.0247%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely satisfied criteria 1, 2, 3, 4, 5, and 6</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 7, 8, 9, 10, and 11 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p></td><td style="vertical-align: top; width: 20.5137%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely satisfied criteria 1, 2, 3, and 4</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 5, 6, 7, and 8 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 9 and 10 to a partial extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">May not have satisfied criteria 11</p></td><td style="vertical-align: top; width: 19.2095%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 1, 2, 3, and 4 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 5, 6, 7, and 8 to a partial extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">May not have satisfied criteria 9, 10, and 11&nbsp;</p></td></tr></tbody></table><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><strong>System Tests - 20 marks</strong></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Quality criteria:</p><ol><li>Tests are well organised (test cases are organised into test scenarios addressing specific functional areas.</li><li>Test are well named</li><li>Preconditions are completely and concretely specified.</li><li>Test data are completely and concretely specified</li><li>Postconditions are completely and concretely specified</li><li>Test steps and expected results for each step are completely and concretely specified</li><li>Tests are objectively evaluated and supporting evidence for test results is provided</li></ol><table cellspacing="0" cellpadding="0" border="1"><tbody><tr><td rowspan="2" style="vertical-align: middle; width: 20.7251%; text-align: center;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;"><strong>System Tests</strong></p></td><td style="vertical-align: top; width: 19.4542%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">HD</p></td><td style="vertical-align: top; width: 20.5137%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">DI</p></td><td style="vertical-align: top; width: 19.8617%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">CR</p></td><td style="vertical-align: top; width: 19.9432%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">PS</p></td></tr><tr><td style="vertical-align: top; width: 19.4542%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">17.0 – 20.0</p></td><td style="vertical-align: top; width: 20.5137%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">15.0 – 16.9</p></td><td style="vertical-align: top; width: 19.8617%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">13.0 – 14.9</p></td><td style="vertical-align: top; width: 19.9432%;" width="25%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;text-align:center;">10.0 – 12.9</p></td></tr><tr><td style="vertical-align: top; width: 20.7251%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">How
 well did the student demonstrate understanding and skills relating to 
software testing in the context of implementing a set of system tests?</p></td><td style="vertical-align: top; width: 19.4542%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">All criteria completely satisfied.</p></td><td style="vertical-align: top; width: 20.5137%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Completely satisfied criteria 1 and 2</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 3, 4, 5, 6, and 7 to a large extent</p></td><td style="vertical-align: top; width: 19.8617%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 1 and 2 to a large extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;">Satisfied criteria 3, 4, 5, 6, and 7 to a partial extent</p></td><td style="vertical-align: top; width: 19.9432%;" width="20%" valign="top"><p style="margin:0in;margin-bottom:.0001pt;">Satisfied all criteria to a partial extent</p><p style="margin:0in;margin-bottom:.0001pt;"><br></p><p style="margin:0in;margin-bottom:.0001pt;"><br></p></td></tr></tbody></table><p style="margin:0in;margin-bottom:.0001pt;"><br></p></div><!-- end word-conent --><div class="word-content"><strong>Reflective Practice (10 marks)</strong></div><div class="word-content"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Quality Criteria:</p><ol><li>Responses address all questions</li><li>Responses are comprehensive, objective, and insightful</li><li>Responses are consistent with an external view, and supported by available evidence</li><li>Responses go beyond description and display critical analysis.</li><li>Logical conclusions and implications for future practice are stated.</li><li>Analysis and conclusions drawn are logically justified and/or correct in terms of subject material</li><li>All content relates directly to critical reflection, analysis, and argument for conclusions reached</li><li>Responses are concise, relevant, easy to read, and easy to understand.</li></ol><table style="margin-left: -0.25pt;" cellspacing="0" cellpadding="0" border="1"><tbody><tr><td rowspan="2" style="vertical-align: middle; width: 21.1084%;" width="21.021897810218977%" valign="top"><p style="margin: 0in 0in 0.0001pt; text-align: center;"><strong>Reflective Practice</strong></p></td><td style="vertical-align: top;" width="18.978102189781023%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;text-align:center;">HD</p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;text-align:center;">DI</p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;text-align:center;">CR</p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;text-align:center;">PS</p></td></tr><tr><td style="text-align: center;">8.5 - 10</td><td style="text-align: center;">7.5 - 8.4</td><td style="text-align: center;">6.5 - 7.4</td><td style="text-align: center;">5.0 - 6.4</td></tr><tr><td style="vertical-align: top;" width="21.021897810218977%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">How
 well does the reflective report demonstrate an ability to reflect on 
and critically evaluate issues encountered involving teamwork, version 
control, and static code review?</p></td><td style="vertical-align: top;" width="18.978102189781023%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Completely achieved all criteria.</p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Completely achieved criteria 1, 2, 3&nbsp;</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Achieved all other criteria to a large extent</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Completely achieved criteria 1 and 3</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Achieved criteria 2 to a large extent</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Achieved all other criteria to a partial extent</p></td><td style="vertical-align: top;" width="20%" valign="top"><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Achieved criteria 1, and 3 to a large extent</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;">Achieved criteria 2 and 4 to a partial extent</p><p style="margin-top:0in;margin-right:0in;margin-bottom:.0001pt;margin-left:0in;"><br></p><p style="margin-top:0in;margin-right:0in;margin-bottom:8.0pt;margin-left:0in;">May not achieve other criteria</p></td></tr></tbody></table></div></div>

			<!-- display graduate learning outcomes -->
			

			<!-- display assessment items if this section contains them -->
			

			<!-- iterate over each child section -->
			

		</div>
					</section>
					<section id="section-6-2-3-4" class=" page-break">

						<div class="level-4">

			<!-- display heading as a header -->
			<div class="sectionHeader section-header">
				<div class="sectionHeaderTitle section-header-title">
					<header>
						
						
						<h5>Presentation</h5>
					</header>
					
				</div>
				<div class="pdf-hide">
					<a class="anchor-link" href="#contentPanel">back to top</a>
				</div>
			</div>

			<!-- display heading inline -->
			

			<!-- display learning outcomes -->
			

			<!-- display section value, if the section type is not a banner  -->
			
			<div class="fr-view section-value"><p>You should submit a zip file through EASTS containing the following:</p><ol style="margin-left: 20px;"><li>A document containing your Master Test Plan</li><li>Your Development Directory containing all source and test code</li><li>A summary document explaining where test files for each section of the assignment can be found</li><li>A document containing your responses to the reflective practice task.</li></ol><p>If you are required to submit using TurnItIn, submit the following:</p><p style="margin-left: 20px;">A Word or PDF document containing the concatenated contents of :</p><ol style="margin-left: 40px;"><li>Your master plan</li><li>A screen shot showing the directory structure and contained files of your test development environment</li><li>The source code for all tests you developed, with each test file separately identified</li><li>Your responses to the reflective practice task.</li></ol></div>

			<!-- display graduate learning outcomes -->
			

			<!-- display assessment items if this section contains them -->
			

			<!-- iterate over each child section -->
			

		</div>
