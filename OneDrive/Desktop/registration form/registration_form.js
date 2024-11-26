function get_info() {
    document.write(
        "ENTERED DETAILS ARE:<br>" +
        "<b>First name:</b> " + document.getElementById("firstname").value +
        "<br><b>Last name:</b> " + document.getElementById("lastname").value +
        "<br><b>Father's name:</b> " + document.getElementById("fathername").value +
        "<br><b>Mother's name:</b> " + document.getElementById("mothername").value +
        "<br><b>E-mail:</b> " + document.getElementById("email").value +
        "<br><b>Phone number:</b> " + document.getElementById("pno").value +
        "<br><b>Date of Birth:</b> " + document.getElementById("dob").value +
        "<br><b>Gender:</b> " + document.getElementById("gender").value +
        "<br><b>Highest Educational Qualification:</b> " + document.getElementById("qualification").value +
        "<br><b>Type of Qualification:</b> " + document.getElementById("qualitype").value
    );
}
