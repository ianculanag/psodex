</div>
</div>
<script>
	$(document).ready(function() {
		$(".peso-format").each(function(index) {
			var value = $(this).html().split(".");
			var whole = value[0];
			if (whole != "-") {
				var decimal = ".".concat(value[1]);
				$(this).html(whole);
				$(this).after("<small class='decimal-value'>" + decimal + "</small>");
			}
		});
		
		$(".transaction-type").each(function() {
			var value = $(this).html();
			$(this).html(value.charAt(0).toUpperCase() + value.slice(1).toLowerCase());
		})
	});
</script>
</body>
</html>