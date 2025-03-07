
<form id="showForm" action="ProductController" method="get">
	<input type="hidden" name="show" value="Show Order">
</form>
<script>
    window.onload = function() {
        document.getElementById("showForm").submit();
    };
</script>
