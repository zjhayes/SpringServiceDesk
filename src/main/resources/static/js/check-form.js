/**
 * Validates that required fields exist and two password fields match.
 */

function checkForm(form)
{
	if(form.displayName.value == "")
	{
		alert("Error: Name field is required.");
		return false;
	}
	else if(form.email.value == "")
	{
		alert("Error: Email field is required.");
		return false;
	}
	else if(form.password.value == "")
	{
		alert("Error: You must enter a Password!");
		form.password.focus();
		return false;
	}
	else if(form.verifypassword.value == "")
	{
		alert("Error: You must Verify your Password!");
		form.verifypassword.focus();
		return false;
	}
	else if(form.password.value != form.verifypassword.value)
	{
		alert("Error: Passwords do not match.");
		return false;
	}
	else
	{
		return true;
	}
}

function checkUserDetails(form)
{
	if(form.displayName.value == "")
	{
		alert("Error: Name field is required.");
		return false;
	}
	else if(form.email.value == "")
	{
		alert("Error: Email field is required.");
		return false;
	}
	else
	{
		return true;
	}
}

function checkPasswordForm(form)
{
	if(form.currentpassword.value != form.oldpassword.value)
	{
		alert("Error: Old Password is incorrect.");
		return false;
	}
	else if(form.password.value != form.verifypassword.value)
	{
		alert("Error: Passwords do not match.");
		return false;
	}
	else
	{
		return true;
	}
}