jQuery(function () {

 var loadFile = function (event) {
                var output = document.getElementById('output');
                output.src = URL.createObjectURL(event.target.files[0]);
            };
jQuery('.button-collapse').sideNav({
     menuWidth: 300, // Default is 240
     edge: 'left', // Choose the horizontal origin
     closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
   }
 );
  $('#chkveg').multiselect({

        includeSelectAllOption: true
    });

    jQuery('.parent').click(function () {

        var isChecked=jQuery(this).is(':checked');
        getResutlFromCheckBox(jQuery(this).val(),isChecked);




    });
        function getResutlFromCheckBox(uid,parentVal) {


            $.ajax({
                url:"http://localhost/paysmart/ajax.php",
                method:'post',
                data:{
                    "parent":parentVal,
                    "uid":uid
                },
                success:function(response){
                    console.log(response);
                },
                error:function(ayaad,status,error){
                    console.log(ayaad);
                },
                complete:function(ayaad){
                    console.log("Complete ");
                },
                dataType:'json',
                async:true

            });

        }
        jQuery('.regularity').click(function () {
            var isChecked=jQuery(this).is(':checked');
            getResutlFromCheckBox2(jQuery(this).val(),isChecked);


        });
        function getResutlFromCheckBox2(uid,parentVal) {


            $.ajax({
                url:"http://localhost/paysmart/ajax.php",
                method:'post',
                data:{
                    "regu":parentVal,
                    "uid":uid
                },
                success:function(response){

                },
                error:function(ayaad,status,error){
                    console.log(error);
                },
                complete:function(ayaad){
                    console.log("Complete ");
                },
                dataType:'json',
                async:true

            });

        }
}
);
