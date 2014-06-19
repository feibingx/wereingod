package com.zhiweiwang.gow.model;

public enum Role {
	普通村民 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	狼人 {
		@Override
		public String getSpecialRoleAction() {
			return "你可以输入「同伴」查看另外的狼人同伴是谁。";
		}
	},
	先知 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	盗贼 {
		@Override
		public String getSpecialRoleAction() {
			return "你可以在两个身份中选择其中一个，输入「身份」查看可以选择的身份。";
		}
	},
	女巫 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	猎人 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	丘比特 {
		@Override
		public String getSpecialRoleAction() {
			return "请输入两个号码来指定情侣，用空格分隔如“3 7”";
		}
	},
	守卫 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	白痴 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	替罪羊 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	长老 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	未分配 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	空闲 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	},
	房主 {
		@Override
		public String getSpecialRoleAction() {
			return "";
		}
	}

	;

	// 第一个夜晚的提示文字
	public abstract String getSpecialRoleAction();
	

}
