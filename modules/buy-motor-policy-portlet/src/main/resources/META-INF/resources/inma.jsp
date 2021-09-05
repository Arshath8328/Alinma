<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alinma Bank</title>
		
		<script language="javascript"> 
			var IAMattributes = "";
			
			function access(){ 
			   IAMattributes='<%=request.getAttribute("IAMattributes")%>';
			   /*
			   {
					"issueLocationAr": "",
					"arabicFatherName": "جابر",
					"englishFatherName": "Gaber",
					"englishName": "Ashraf Gaber Gaber Gaber",
					"gender": "Male",
					"dobHijri": "1408/06/01",
					"cardIssueDateHijri": "1435/06/03",
					"englishFirstName": "Ashraf",
					"issueLocationEn": "Riyadh",
					"cardIssueDateGregorian": "Thu Apr 05 03:00:00 AST 2014",
					"englishGrandFatherName": "Gaber",
					"userid": "1052031281",
					"arabicGrandFatherName": "جابر",
					"arabicNationality": "العربية السعودية",
					"arabicFirstName": "اشرف",
					"nationalityCode": "113",
					"nationality": "Saudi Arabia",
					"englishFamilyName": "Gaber",
					"dob": "Thu Feb 15 03:00:00 AST 1988",
					"lang": "ar",
					"arabicFamilyName": "جابر"
				}
			   */
			   	window.postMessage({
					'msgType': 'resultsPage',
					'accntData': IAMattributes
				}, "*");
			   console.log(window.webkit);
			   console.log(Window.webkit.messageHandlers);
			   if (window.webkit && Window.webkit.messageHandlers) {
				      console.log('postmessage call on webkit');
				      window.webkit.messageHandlers.cordova_iab.postMessage("this is a message");
				}

			} 

		</script> 
	</head>
	<body onload="access()">
		<p>Helloo from Inma Web</p>
	</body>
</html>


