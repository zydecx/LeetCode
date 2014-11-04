/*
* bootstrap-table - v1.3.0 - 2014-10-16
* https://github.com/wenzhixin/bootstrap-table
* Copyright (c) 2014 zhixin wen
* Licensed MIT License
*/
!function(a){"use strict";var b=function(a){var b=arguments,c=!0,d=1;return a=a.replace(/%s/g,function(){var a=b[d++];return"undefined"==typeof a?(c=!1,""):a}),c?a:""},c=function(b,c,d,e){var f="";return a.each(b,function(a,b){return b[c]===e?(f=b[d],!1):!0}),f},d=function(b,c){var d=-1;return a.each(b,function(a,b){return b.field===c?(d=a,!1):!0}),d},e=function(){var b,c,d=a("<p/>").addClass("fixed-table-scroll-inner"),e=a("<div/>").addClass("fixed-table-scroll-outer");return e.append(d),a("body").append(e),b=d[0].offsetWidth,e.css("overflow","scroll"),c=d[0].offsetWidth,b==c&&(c=e[0].clientWidth),e.remove(),b-c},f=function(b,c,d,e){if("string"==typeof c){var f=c.split(".");f.length>1?(c=window,a.each(f,function(a,b){c=c[b]})):c=window[c]}return"object"==typeof c?c:"function"==typeof c?c.apply(b,d):e},g=function(b,c){this.options=c,this.$el=a(b),this.$el_=this.$el.clone(),this.timeoutId_=0,this.init()};g.DEFAULTS={classes:"table table-hover",height:void 0,undefinedText:"-",sortName:void 0,sortOrder:"asc",striped:!1,columns:[],data:[],method:"get",url:void 0,cache:!0,contentType:"application/json",queryParams:function(a){return a},queryParamsType:"limit",responseHandler:function(a){return a},pagination:!1,sidePagination:"client",totalRows:0,pageNumber:1,pageSize:10,pageList:[10,25,50,100],search:!1,selectItemName:"btSelectItem",showHeader:!0,showColumns:!1,showRefresh:!1,showToggle:!1,minimumCountColumns:1,idField:void 0,cardView:!1,clickToSelect:!1,singleSelect:!1,toolbar:void 0,checkboxHeader:!0,sortable:!0,maintainSelected:!1,rowStyle:function(){return{}},formatLoadingMessage:function(){return"Loading, please wait…"},formatRecordsPerPage:function(a){return b("%s records per page",a)},formatShowingRows:function(a,c,d){return b("Showing %s to %s of %s rows",a,c,d)},formatSearch:function(){return"Search"},formatNoMatches:function(){return"No matching records found"},onAll:function(){return!1},onClickRow:function(){return!1},onDblClickRow:function(){return!1},onSort:function(){return!1},onCheck:function(){return!1},onUncheck:function(){return!1},onCheckAll:function(){return!1},onUncheckAll:function(){return!1},onLoadSuccess:function(){return!1},onLoadError:function(){return!1},onColumnSwitch:function(){return!1}},g.COLUMN_DEFAULTS={radio:!1,checkbox:!1,checkboxEnabled:!0,field:void 0,title:void 0,"class":void 0,align:void 0,halign:void 0,valign:void 0,width:void 0,sortable:!1,order:"asc",visible:!0,switchable:!0,clickToSelect:!0,formatter:void 0,events:void 0,sorter:void 0,cellStyle:void 0},g.EVENTS={"all.bs.table":"onAll","click-row.bs.table":"onClickRow","dbl-click-row.bs.table":"onDblClickRow","sort.bs.table":"onSort","check.bs.table":"onCheck","uncheck.bs.table":"onUncheck","check-all.bs.table":"onCheckAll","uncheck-all.bs.table":"onUncheckAll","load-success.bs.table":"onLoadSuccess","load-error.bs.table":"onLoadError","column-switch.bs.table":"onColumnSwitch"},g.prototype.init=function(){this.initContainer(),this.initTable(),this.initHeader(),this.initData(),this.initToolbar(),this.initPagination(),this.initBody(),this.initServer()},g.prototype.initContainer=function(){this.$container=a(['<div class="bootstrap-table">','<div class="fixed-table-toolbar"></div>','<div class="fixed-table-container">','<div class="fixed-table-header"><table></table></div>','<div class="fixed-table-body">','<div class="fixed-table-loading">',this.options.formatLoadingMessage(),"</div>","</div>",'<div class="fixed-table-pagination"></div>',"</div>","</div>"].join("")),this.$container.insertAfter(this.$el),this.$container.find(".fixed-table-body").append(this.$el),this.$container.after('<div class="clearfix"></div>'),this.$loading=this.$container.find(".fixed-table-loading"),this.$el.addClass(this.options.classes),this.options.striped&&this.$el.addClass("table-striped")},g.prototype.initTable=function(){var b=this,c=[],d=[];this.$header=this.$el.find("thead"),this.$header.length||(this.$header=a("<thead></thead>").appendTo(this.$el)),this.$header.find("tr").length||this.$header.append("<tr></tr>"),this.$header.find("th").each(function(){var b=a.extend({},{title:a(this).html(),"class":a(this).attr("class")},a(this).data());c.push(b)}),this.options.columns=a.extend([],c,this.options.columns),a.each(this.options.columns,function(c,d){b.options.columns[c]=a.extend({},g.COLUMN_DEFAULTS,{field:c},d)}),this.options.data.length||(this.$el.find("tbody tr").each(function(){var c={};a(this).find("td").each(function(d){c[b.options.columns[d].field]=a(this).html()}),d.push(c)}),this.options.data=d)},g.prototype.initHeader=function(){var c=this,d=[],e=[];this.header={fields:[],styles:[],classes:[],formatters:[],events:[],sorters:[],cellStyles:[],clickToSelects:[]},a.each(this.options.columns,function(a,f){{var g="",h=b("text-align: %s; ",f.align)+b("vertical-align: %s; ",f.valign),i=b(' class="%s"',f["class"]);c.options.sortOrder||f.order}f.visible&&(d.push(f),c.header.fields.push(f.field),c.header.styles.push(h),c.header.classes.push(i),c.header.formatters.push(f.formatter),c.header.events.push(f.events),c.header.sorters.push(f.sorter),c.header.cellStyles.push(f.cellStyle),c.header.clickToSelects.push(f.clickToSelect),f.halign&&(h=b("text-align: %s; ",f.halign)+b("vertical-align: %s; ",f.valign)),h+=b("width: %spx; ",f.checkbox||f.radio?36:f.width),e.push("<th",f.checkbox||f.radio?b(' class="bs-checkbox %s"',f["class"]||""):i,b(' style="%s"',h),">"),e.push(b('<div class="th-inner %s">',c.options.sortable&&f.sortable?"sortable":"")),g=f.title,c.options.sortName===f.field&&c.options.sortable&&f.sortable&&(g+=c.getCaretHtml()),f.checkbox&&(!c.options.singleSelect&&c.options.checkboxHeader&&(g='<input name="btSelectAll" type="checkbox" />'),c.header.stateField=f.field),f.radio&&(g="",c.header.stateField=f.field,c.options.singleSelect=!0),e.push(g),e.push("</div>"),e.push('<div class="fht-cell"></div>'),e.push("</th>"))}),this.$header.find("tr").html(e.join("")),this.$header.find("th").each(function(b){a(this).data(d[b])}),this.$container.off("click","th").on("click","th",function(b){c.options.sortable&&a(this).data().sortable&&c.onSort(b)}),!this.options.showHeader||this.options.cardView?(this.$header.hide(),this.$container.find(".fixed-table-header").hide(),this.$loading.css("top",0)):(this.$header.show(),this.$container.find(".fixed-table-header").show(),this.$loading.css("top","37px")),this.$selectAll=this.$header.find('[name="btSelectAll"]'),this.$container.off("click",'[name="btSelectAll"]').on("click",'[name="btSelectAll"]',function(){var b=a(this).prop("checked");c[b?"checkAll":"uncheckAll"]()})},g.prototype.initData=function(a,b){this.data=b?this.data.concat(a):a||this.options.data,this.options.data=this.data,"server"!==this.options.sidePagination&&this.initSort()},g.prototype.initSort=function(){var b=this,c=this.options.sortName,d="desc"===this.options.sortOrder?-1:1,e=a.inArray(this.options.sortName,this.header.fields);-1!==e&&this.data.sort(function(a,g){var h=f(b.header,b.header.sorters[e],[a[c],g[c]]);return void 0!==h?d*h:a[c]===g[c]?0:a[c]<g[c]?-1*d:d})},g.prototype.onSort=function(b){var c=a(b.currentTarget),d=this.$header.find("th").eq(c.index());return this.$header.add(this.$header_).find("span.order").remove(),this.options.sortName===c.data("field")?this.options.sortOrder="asc"===this.options.sortOrder?"desc":"asc":(this.options.sortName=c.data("field"),this.options.sortOrder="asc"===c.data("order")?"desc":"asc"),this.trigger("sort",this.options.sortName,this.options.sortOrder),c.add(d).data("order",this.options.sortOrder).find(".th-inner").append(this.getCaretHtml()),"server"===this.options.sidePagination?void this.initServer():(this.initSort(),void this.initBody())},g.prototype.initToolbar=function(){var c,d,e=this,f=[],g=0;this.$toolbar=this.$container.find(".fixed-table-toolbar").html(""),"string"==typeof this.options.toolbar&&a('<div class="bars pull-left"></div>').appendTo(this.$toolbar).append(a(this.options.toolbar)),f=['<div class="columns btn-group pull-right">'],this.options.showRefresh&&f.push('<button class="btn btn-default" type="button" name="refresh">','<i class="glyphicon glyphicon-refresh icon-refresh"></i>',"</button>"),this.options.showToggle&&f.push('<button class="btn btn-default" type="button" name="toggle">','<i class="glyphicon glyphicon glyphicon-list-alt icon-list-alt"></i>',"</button>"),this.options.showColumns&&(f.push(b('<div class="keep-open %s">',this.options.showRefresh||this.options.showToggle?"btn-group":""),'<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">','<i class="glyphicon glyphicon-th icon-th"></i>',' <span class="caret"></span>',"</button>",'<ul class="dropdown-menu" role="menu">'),a.each(this.options.columns,function(a,c){if(!c.radio&&!c.checkbox){var d=c.visible?' checked="checked"':"";c.switchable&&f.push(b('<li><label><input type="checkbox" data-field="%s" value="%s"%s> %s</label></li>',c.field,a,d,c.title))}}),f.push("</ul>","</div>")),f.push("</div>"),f.length>2&&this.$toolbar.append(f.join("")),this.options.showRefresh&&this.$toolbar.find('button[name="refresh"]').off("click").on("click",a.proxy(this.refresh,this)),this.options.showToggle&&this.$toolbar.find('button[name="toggle"]').off("click").on("click",function(){e.options.cardView=!e.options.cardView,e.initHeader(),e.initBody()}),this.options.showColumns&&(c=this.$toolbar.find(".keep-open"),c.find("li").off("click").on("click",function(a){a.stopImmediatePropagation()}),c.find("input").off("click").on("click",function(){var b=a(this);e.toggleColumn(b.val(),b.prop("checked"),!1),e.trigger("column-switch",a(this).data("field"),b.prop("checked"))})),this.options.search&&(f=[],f.push('<div class="pull-right search">',b('<input class="form-control" type="text" placeholder="%s">',this.options.formatSearch()),"</div>"),this.$toolbar.append(f.join("")),d=this.$toolbar.find(".search input"),d.off("keyup").on("keyup",function(a){clearTimeout(g),g=setTimeout(function(){e.onSearch(a)},500)}))},g.prototype.onSearch=function(b){var c=a.trim(a(b.currentTarget).val());a(b.currentTarget).val(c),c!==this.searchText&&(this.searchText=c,this.options.pageNumber=1,this.initSearch(),this.updatePagination())},g.prototype.initSearch=function(){var b=this;if("server"!==this.options.sidePagination){var c=this.searchText&&this.searchText.toLowerCase();this.data=c?a.grep(this.options.data,function(d,e){g=a.isNumeric(g)?parseInt(g,10):g;for(var g in d){var h=d[g];if(h=f(b.header,b.header.formatters[a.inArray(g,b.header.fields)],[h,d,e],h),-1!==a.inArray(g,b.header.fields)&&("string"==typeof h||"number"==typeof h)&&-1!==(h+"").toLowerCase().indexOf(c))return!0}return!1}):this.options.data}},g.prototype.initPagination=function(){if(this.$pagination=this.$container.find(".fixed-table-pagination"),this.options.pagination){var c,d,e,f,g,h,i,j,k,l=this,m=[],n=this.searchText?this.data:this.options.data;"server"!==this.options.sidePagination&&(this.options.totalRows=n.length),this.totalPages=0,this.options.totalRows&&(this.totalPages=~~((this.options.totalRows-1)/this.options.pageSize)+1),this.totalPages>0&&this.options.pageNumber>this.totalPages&&(this.options.pageNumber=this.totalPages),this.pageFrom=(this.options.pageNumber-1)*this.options.pageSize+1,this.pageTo=this.options.pageNumber*this.options.pageSize,this.pageTo>this.options.totalRows&&(this.pageTo=this.options.totalRows),m.push('<div class="pull-left pagination-detail">','<span class="pagination-info">',this.options.formatShowingRows(this.pageFrom,this.pageTo,this.options.totalRows),"</span>"),m.push('<span class="page-list">');var o=['<span class="btn-group dropup">','<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">','<span class="page-size">',this.options.pageSize,"</span>",' <span class="caret"></span>',"</button>",'<ul class="dropdown-menu" role="menu">'],p=this.options.pageList;if("string"==typeof this.options.pageList){var q=this.options.pageList.slice(1,-1).replace(/ /g,"").split(",");p=[],a.each(q,function(a,b){p.push(+b)})}for(a.each(p,function(a,c){var d=c===l.options.pageSize?' class="active"':"";o.push(b('<li%s><a href="javascript:void(0)">%s</a></li>',d,c))}),o.push("</ul></span>"),m.push(this.options.formatRecordsPerPage(o.join(""))),m.push("</span>"),m.push("</div>",'<div class="pull-right pagination">','<ul class="pagination">','<li class="page-first"><a href="javascript:void(0)">&lt;&lt;</a></li>','<li class="page-pre"><a href="javascript:void(0)">&lt;</a></li>'),this.totalPages<5?(d=1,e=this.totalPages):(d=this.options.pageNumber-2,e=d+4,1>d&&(d=1,e=5),e>this.totalPages&&(e=this.totalPages,d=e-4)),c=d;e>=c;c++)m.push('<li class="page-number'+(c===this.options.pageNumber?" active":"")+'">','<a href="javascript:void(0)">',c,"</a>","</li>");m.push('<li class="page-next"><a href="javascript:void(0)">&gt;</a></li>','<li class="page-last"><a href="javascript:void(0)">&gt;&gt;</a></li>',"</ul>","</div>"),this.$pagination.html(m.join("")),f=this.$pagination.find(".page-list a"),g=this.$pagination.find(".page-first"),h=this.$pagination.find(".page-pre"),i=this.$pagination.find(".page-next"),j=this.$pagination.find(".page-last"),k=this.$pagination.find(".page-number"),this.options.pageNumber<=1&&(g.addClass("disabled"),h.addClass("disabled")),this.options.pageNumber>=this.totalPages&&(i.addClass("disabled"),j.addClass("disabled")),f.off("click").on("click",a.proxy(this.onPageListChange,this)),g.off("click").on("click",a.proxy(this.onPageFirst,this)),h.off("click").on("click",a.proxy(this.onPagePre,this)),i.off("click").on("click",a.proxy(this.onPageNext,this)),j.off("click").on("click",a.proxy(this.onPageLast,this)),k.off("click").on("click",a.proxy(this.onPageNumber,this))}},g.prototype.updatePagination=function(){this.options.maintainSelected||this.resetRows(),this.initPagination(),"server"===this.options.sidePagination?this.initServer():this.initBody()},g.prototype.onPageListChange=function(b){var c=a(b.currentTarget);c.parent().addClass("active").siblings().removeClass("active"),this.options.pageSize=+c.text(),this.$toolbar.find(".page-size").text(this.options.pageSize),this.updatePagination()},g.prototype.onPageFirst=function(){this.options.pageNumber=1,this.updatePagination()},g.prototype.onPagePre=function(){this.options.pageNumber--,this.updatePagination()},g.prototype.onPageNext=function(){this.options.pageNumber++,this.updatePagination()},g.prototype.onPageLast=function(){this.options.pageNumber=this.totalPages,this.updatePagination()},g.prototype.onPageNumber=function(b){this.options.pageNumber!==+a(b.currentTarget).text()&&(this.options.pageNumber=+a(b.currentTarget).text(),this.updatePagination())},g.prototype.initBody=function(d){var e=this,g=[],h=this.getData();this.$body=this.$el.find("tbody"),this.$body.length||(this.$body=a("<tbody></tbody>").appendTo(this.$el)),"server"===this.options.sidePagination&&(h=this.data),this.options.pagination&&"server"!==this.options.sidePagination||(this.pageFrom=1,this.pageTo=h.length);for(var i=this.pageFrom-1;i<this.pageTo;i++){var j=h[i],k={},l=[];if(k=f(this.options,this.options.rowStyle,[j,i],k),k&&k.css)for(var m in k.css)l.push(m+": "+k.css[m]);g.push("<tr",b(' class="%s"',k.classes),b(' data-index="%s"',i),">"),this.options.cardView&&g.push(b('<td colspan="%s">',this.header.fields.length)),a.each(this.header.fields,function(a,d){var h="",m=j[d],n="",o={},p=e.header.classes[a];if(k=b('style="%s"',l.concat(e.header.styles[a]).join("; ")),m=f(e.header,e.header.formatters[a],[m,j,i],m),o=f(e.header,e.header.cellStyles[a],[m,j,i],o),o.classes&&(p=b(' class="%s"',o.classes)),o.css){l=[];for(var q in o.css)l.push(q+": "+o.css[q]);k=b('style="%s"',l.concat(e.header.styles[a]).join("; "))}if(e.options.columns[a].checkbox||e.options.columns[a].radio){if(e.options.cardView)return!0;n=e.options.columns[a].checkbox?"checkbox":n,n=e.options.columns[a].radio?"radio":n,h=['<td class="bs-checkbox">',"<input"+b(' data-index="%s"',i)+b(' name="%s"',e.options.selectItemName)+b(' type="%s"',n)+b(' value="%s"',j[e.options.idField])+b(' checked="%s"',1===+m||m&&m.checked?"checked":void 0)+b(' disabled="%s"',!e.options.columns[a].checkboxEnabled||m&&m.disabled?"disabled":void 0)+" />","</td>"].join("")}else m="undefined"==typeof m?e.options.undefinedText:m,h=e.options.cardView?['<div class="card-view">',e.options.showHeader?b('<span class="title" %s>%s</span>',k,c(e.options.columns,"field","title",d)):"",b('<span class="value">%s</span>',m),"</div>"].join(""):[b("<td%s %s>",p,k),m,"</td>"].join("");g.push(h)}),this.options.cardView&&g.push("</td>"),g.push("</tr>")}g.length||g.push('<tr class="no-records-found">',b('<td colspan="%s">%s</td>',this.header.fields.length,this.options.formatNoMatches()),"</tr>"),this.$body.html(g.join("")),d||this.$container.find(".fixed-table-body").scrollTop(0),this.$body.find("> tr > td").off("click").on("click",function(){var c=a(this).parent();e.trigger("click-row",e.data[c.data("index")],c),e.options.clickToSelect&&e.header.clickToSelects[c.children().index(a(this))]&&c.find(b('[name="%s"]',e.options.selectItemName)).trigger("click")}),this.$body.find("tr").off("dblclick").on("dblclick",function(){e.trigger("dbl-click-row",e.data[a(this).data("index")],a(this))}),this.$selectItem=this.$body.find(b('[name="%s"]',this.options.selectItemName)),this.$selectItem.off("click").on("click",function(b){b.stopImmediatePropagation(),a(this).is(":radio")&&a(this).prop("checked",!0);var c=e.$selectItem.filter(":enabled").length===e.$selectItem.filter(":enabled").filter(":checked").length,d=a(this).prop("checked"),f=e.data[a(this).data("index")];e.$selectAll.add(e.$selectAll_).prop("checked",c),f[e.header.stateField]=d,e.trigger(d?"check":"uncheck",f),e.options.singleSelect&&(e.$selectItem.not(this).each(function(){e.data[a(this).data("index")][e.header.stateField]=!1}),e.$selectItem.filter(":checked").not(this).prop("checked",!1)),e.updateSelected()}),a.each(this.header.events,function(b,c){if(c){"string"==typeof c&&(c=f(null,c));for(var d in c)e.$body.find("tr").each(function(){var f=a(this),g=f.find("td").eq(b),h=d.indexOf(" "),i=d.substring(0,h),j=d.substring(h+1),k=c[d];g.find(j).off(i).on(i,function(a){var c=f.data("index"),d=e.data[c],g=d[e.header.fields[b]];k(a,g,d,c)})})}}),this.updateSelected(),this.resetView()},g.prototype.initServer=function(b){var c=this,d={},e={pageSize:this.options.pageSize,pageNumber:this.options.pageNumber,searchText:this.searchText,sortName:this.options.sortName,sortOrder:this.options.sortOrder};this.options.url&&("limit"===this.options.queryParamsType&&(e={limit:e.pageSize,offset:e.pageSize*(e.pageNumber-1),search:e.searchText,sort:e.sortName,order:e.sortOrder}),d=f(this.options,this.options.queryParams,[e],d),d!==!1&&(b||this.$loading.show(),a.ajax({type:this.options.method,url:this.options.url,data:d,cache:this.options.cache,contentType:this.options.contentType,dataType:"json",success:function(a){a=f(c.options,c.options.responseHandler,[a],a);var b=a;"server"===c.options.sidePagination&&(c.options.totalRows=a.total,b=a.rows),c.load(b),c.trigger("load-success",b)},error:function(a){c.trigger("load-error",a.status)},complete:function(){b||c.$loading.hide()}})))},g.prototype.getCaretHtml=function(){return['<span class="order'+("desc"===this.options.sortOrder?"":" dropup")+'">','<span class="caret" style="margin: 10px 5px;"></span>',"</span>"].join("")},g.prototype.updateSelected=function(){this.$selectItem.each(function(){a(this).parents("tr")[a(this).prop("checked")?"addClass":"removeClass"]("selected")})},g.prototype.updateRows=function(b){var c=this;this.$selectItem.each(function(){c.data[a(this).data("index")][c.header.stateField]=b})},g.prototype.resetRows=function(){var b=this;a.each(this.data,function(a,c){b.$selectAll.prop("checked",!1),b.$selectItem.prop("checked",!1),c[b.header.stateField]=!1})},g.prototype.trigger=function(b){var c=Array.prototype.slice.call(arguments,1);b+=".bs.table",this.options[g.EVENTS[b]].apply(this.options,c),this.$el.trigger(a.Event(b),c),this.options.onAll(b,c),this.$el.trigger(a.Event("all.bs.table"),[b,c])},g.prototype.resetHeader=function(){var b=this,c=this.$container.find(".fixed-table-header"),d=this.$container.find(".fixed-table-body"),f=this.$el.width()>d.width()?e():0;return this.$el.is(":hidden")?(clearTimeout(this.timeoutId_),void(this.timeoutId_=setTimeout(a.proxy(this.resetHeader,this),100))):(this.$header_=this.$header.clone(!0,!0),this.$selectAll_=this.$header_.find('[name="btSelectAll"]'),void setTimeout(function(){c.css({height:"37px","border-bottom":"1px solid #dddddd","margin-right":f}).find("table").css("width",b.$el.css("width")).html("").attr("class",b.$el.attr("class")).append(b.$header_),b.$header.find("th").each(function(c){b.$header_.find("th").eq(c).data(a(this).data())}),b.$body.find("tr:first-child:not(.no-records-found) > *").each(function(c){b.$header_.find("div.fht-cell").eq(c).width(a(this).innerWidth())}),b.$el.css("margin-top",-b.$header.height()),d.off("scroll").on("scroll",function(){c.scrollLeft(a(this).scrollLeft())})}))},g.prototype.toggleColumn=function(a,c,d){if(-1!==a&&(this.options.columns[a].visible=c,this.initHeader(),this.initSearch(),this.initPagination(),this.initBody(),this.options.showColumns)){var e=this.$toolbar.find(".keep-open input").prop("disabled",!1);d&&e.filter(b('[value="%s"]',a)).prop("checked",c),e.filter(":checked").length<=this.options.minimumCountColumns&&e.filter(":checked").prop("disabled",!0)}},g.prototype.resetView=function(a){{var b=this;this.header}if(a&&a.height&&(this.options.height=a.height),this.$selectAll.prop("checked",this.$selectItem.length>0&&this.$selectItem.length===this.$selectItem.filter(":checked").length),this.options.height){var c=+this.$toolbar.children().outerHeight(!0),d=+this.$pagination.children().outerHeight(!0),e=this.options.height-c-d;this.$container.find(".fixed-table-container").css("height",e+"px")}return this.options.cardView?(b.$el.css("margin-top","0"),void b.$container.find(".fixed-table-container").css("padding-bottom","0")):(this.options.showHeader&&this.options.height&&this.resetHeader(),void(this.options.height&&this.options.showHeader&&this.$container.find(".fixed-table-container").css("padding-bottom","37px")))},g.prototype.getData=function(){return this.searchText?this.data:this.options.data},g.prototype.load=function(a){this.initData(a),this.initSearch(),this.initPagination(),this.initBody()},g.prototype.append=function(a){this.initData(a,!0),this.initSearch(),this.initPagination(),this.initBody(!0)},g.prototype.remove=function(b){var c,d,e=this.options.data.length;if(b.hasOwnProperty("field")&&b.hasOwnProperty("values")){for(c=e-1;c>=0;c--){if(d=this.options.data[c],!d.hasOwnProperty(b.field))return;-1!==a.inArray(d[b.field],b.values)&&this.options.data.splice(c,1)}e!==this.options.data.length&&(this.initSearch(),this.initPagination(),this.initBody(!0))}},g.prototype.updateRow=function(b){b.hasOwnProperty("index")&&b.hasOwnProperty("row")&&(a.extend(this.data[b.index],b.row),this.initBody())},g.prototype.mergeCells=function(b){var c,d,e=b.index,f=a.inArray(b.field,this.header.fields),g=b.rowspan||1,h=b.colspan||1,i=this.$body.find("tr"),j=i.eq(e).find("td").eq(f);if(!(0>e||0>f||e>=this.data.length)){for(c=e;e+g>c;c++)for(d=f;f+h>d;d++)i.eq(c).find("td").eq(d).hide();j.attr("rowspan",g).attr("colspan",h).show(10,a.proxy(this.resetView,this))}},g.prototype.getSelections=function(){var b=this;return a.grep(this.data,function(a){return a[b.header.stateField]})},g.prototype.checkAll=function(){this.$selectAll.add(this.$selectAll_).prop("checked",!0),this.$selectItem.filter(":enabled").prop("checked",!0),this.updateRows(!0),this.updateSelected(),this.trigger("check-all")},g.prototype.uncheckAll=function(){this.$selectAll.add(this.$selectAll_).prop("checked",!1),this.$selectItem.filter(":enabled").prop("checked",!1),this.updateRows(!1),this.updateSelected(),this.trigger("uncheck-all")},g.prototype.destroy=function(){this.$el.insertBefore(this.$container),a(this.options.toolbar).insertBefore(this.$el),this.$container.next().remove(),this.$container.remove(),this.$el.html(this.$el_.html()).attr("class",this.$el_.attr("class")||"")},g.prototype.showLoading=function(){this.$loading.show()},g.prototype.hideLoading=function(){this.$loading.hide()},g.prototype.refresh=function(a){a&&a.url&&(this.options.url=a.url),this.initServer(a&&a.silent)},g.prototype.showColumn=function(a){this.toggleColumn(d(this.options.columns,a),!0,!0)},g.prototype.hideColumn=function(a){this.toggleColumn(d(this.options.columns,a),!1,!0)},a.fn.bootstrapTable=function(b,c){var d,e=["getSelections","getData","load","append","remove","updateRow","mergeCells","checkAll","uncheckAll","refresh","resetView","destroy","showLoading","hideLoading","showColumn","hideColumn"];return this.each(function(){var f=a(this),h=f.data("bootstrap.table"),i=a.extend({},g.DEFAULTS,f.data(),"object"==typeof b&&b);if("string"==typeof b){if(a.inArray(b,e)<0)throw"Unknown method: "+b;if(!h)return;d=h[b](c),"destroy"===b&&f.removeData("bootstrap.table")}h||f.data("bootstrap.table",h=new g(this,i))}),"undefined"==typeof d?this:d},a.fn.bootstrapTable.Constructor=g,a.fn.bootstrapTable.defaults=g.DEFAULTS,a.fn.bootstrapTable.columnDefaults=g.COLUMN_DEFAULTS,a(function(){a('[data-toggle="table"]').bootstrapTable()})}(jQuery);